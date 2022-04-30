package com.example.composetdaapp.ui.fragments

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.composetdaapp.MainActivity
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.utils.Resource
import com.example.composetdaapp.R
import com.example.composetdaapp.data.entities.orders.place.Instrument
import com.example.composetdaapp.data.entities.orders.place.OrderLegCollection
import com.example.composetdaapp.data.entities.orders.place.PlaceOrder
import com.example.composetdaapp.databinding.ChartFragmentBinding
import com.example.composetdaapp.ui.viewmodels.ChartViewModel
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import timber.log.Timber

import java.util.*


class ChartFragment : Fragment() {


    private lateinit var binding: ChartFragmentBinding

    private val viewModel: ChartViewModel by activityViewModels()

    private lateinit var mainActivity: MainActivity

    private var isMarketDay: Boolean = false


    var orderPayload = PlaceOrder(
        orderLegCollection = listOf(
            OrderLegCollection(
                instrument = Instrument(assetType = "EQUITY", symbol = null),
            )
        ),
        orderStrategyType = "SINGLE"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChartFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = activity as MainActivity
        viewModel.start(mainActivity.tickerSymbol)
        setUpObservers()
        viewModel.accountDetailsLiveData
        binding.posLayout.visibility = VISIBLE

        viewModel.getAccountDetails(mainActivity.tickerSymbol)
        viewModel.getSymbolDetails()

        isMarketDay = viewModel.isMarketOpen()
        //we need open and close in millis to be able to pull today's intra day candle data(API shenanigans).
        val marketOpenInMilli = viewModel.marketOpenToMilli()
        val marketCloseInMilli = viewModel.marketCloseToMilli()

        binding.toggleButton.check(R.id.intraDayBtn)

        //avoid if statements
        if (isMarketDay) {
            viewModel.getIntraDayChartData(
                marketOpenInMilli.toString(),
                marketCloseInMilli.toString()
            )
        } else {
            viewModel.getChartData("day", "1", "minute")
        }

        binding.cancelBtn.setOnClickListener {

            binding.motionLayout.startState
        }

        binding.intraDayBtn.setOnClickListener {

            viewModel.chartMediatorLiveData.removeSource(viewModel.symbolLiveData)
            viewModel.candleEntries.clear()
            if (isMarketDay) {
                viewModel.getIntraDayChartData(
                    marketOpenInMilli.toString(),
                    marketCloseInMilli.toString()
                )
            } else {
                viewModel.getChartData("day", "1", "minute")
            }

        }



        binding.monthBtn.setOnClickListener {
            viewModel.chartMediatorLiveData.removeSource(viewModel.symbolLiveData)
            //clear previous candle timeframe
            viewModel.candleEntries.clear()
            viewModel.getChartData("month", "1", "daily")

        }

        binding.sixMonthsBtn.setOnClickListener {
            viewModel.chartMediatorLiveData.removeSource(viewModel.symbolLiveData)
            viewModel.candleEntries.clear()
            viewModel.getChartData("month", "6", "daily")

        }

        binding.oneYearBtn.setOnClickListener {
            viewModel.chartMediatorLiveData.removeSource(viewModel.symbolLiveData)
            viewModel.candleEntries.clear()
            viewModel.getChartData("year", "1", "daily")

        }


        binding.btnBuy.setOnClickListener {
            binding.motionLayout.transitionToEnd()
            binding.effectBtn.check(R.id.effectBuy)

        }

        binding.btnSell.setOnClickListener {
            binding.motionLayout.transitionToEnd()
            binding.effectBtn.check(R.id.effectSell)
        }

        binding.effectBtn.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.effectBuy -> {
                        orderPayload.orderLegCollection[0].instruction = "BUY"
                    }

                    R.id.effectSell -> {
                        orderPayload.orderLegCollection[0].instruction = "SELL"

                    }
                }
            } else {
                if (group.checkedButtonId == View.NO_ID) {
                    // do something when nothing selected
                }
            }
        }
        binding.orderBtn.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.marketBtn -> {
                        orderPayload.orderType = "MARKET"
                        binding.expirationBtn.check(R.id.dayBtn)
                        binding.gtcBtn.isEnabled = false
                        binding.dayExtBtn.isEnabled = false
                        binding.gtcExtBtn.isEnabled = false
                        binding.priceInput.visibility = GONE
                    }
                    R.id.limitBtn -> {
                        orderPayload.orderType = "LIMIT"
                        binding.gtcBtn.isEnabled = true
                        binding.dayExtBtn.isEnabled = true
                        binding.gtcExtBtn.isEnabled = true
                        binding.priceInput.visibility = VISIBLE

                    }
                }
            }
        }

        binding.expirationBtn.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.dayBtn -> {
                        orderPayload.session = "NORMAL"
                        orderPayload.duration = "DAY"
                    }
                    R.id.gtcBtn -> {
                        orderPayload.session = "NORMAL"
                        orderPayload.duration = "GOOD_TILL_CANCEL"
                    }
                    R.id.dayExtBtn -> {
                        orderPayload.session = "SEAMLESS"
                        orderPayload.duration = "DAY"
                    }
                    R.id.gtcExtBtn -> {
                        orderPayload.session = "SEAMLESS"
                        orderPayload.duration = "GOOD_TILL_CANCEL"
                    }

                }
            } else {
                binding.expirationBtn.check(R.id.marketBtn)
                //R.id.dayBtn ->{ }
            }

        }
        binding.sharesInputText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                binding.sharesInputText.clearFocus()
                // hide virtual keyboard
                val imm: InputMethodManager? = requireContext().getSystemService(
                    INPUT_METHOD_SERVICE
                ) as InputMethodManager
                imm?.hideSoftInputFromWindow(binding.sharesInputText.windowToken, 0)
                return@OnEditorActionListener true
            }
            false
        })
        binding.Confirm.setOnClickListener {

            orderPayload.price = binding.priceInputText.text.toString()
            orderPayload.orderLegCollection[0].quantity =
                binding.sharesInputText.text.toString().toInt()
            orderPayload.orderLegCollection[0].instrument.symbol =
                viewModel.tickerSymbol.value.toString()
            viewModel.placeOrder(order = orderPayload)


            viewModel.getAllOrders()
            binding.expirationBtn.clearChecked()
            binding.priceInputText.text?.clear()
            binding.sharesInputText.text?.clear()
            binding.priceInput.visibility = VISIBLE
            binding.motionLayout.transitionToStart()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.candleEntries.clear()
        binding.candleChart.clear()

        viewModel.chartMediatorLiveData.removeSource(viewModel.symbolLiveData)
        //Clearing previous candle candleEntries.

    }


    private fun setUpCandleChart(
        candleEntries: MutableList<CandleEntry>,
        indicatorEntries: List<Entry>
    ) {

        val pinkColor = Color.parseColor("#FE657A")

        val data = CombinedData()

        val chartData = CandleDataSet(candleEntries, "")
        data.setData(CandleData(chartData))
        chartData.color = Color.rgb(80, 80, 80)
        chartData.shadowWidth = 0.7f
        chartData.shadowColorSameAsCandle = true
        chartData.decreasingColor = Color.RED
        chartData.decreasingPaintStyle = Paint.Style.FILL
        chartData.increasingColor = Color.rgb(122, 242, 84)
        chartData.increasingPaintStyle = Paint.Style.FILL
        chartData.neutralColor = Color.WHITE
        chartData.valueTextSize = 0f


        /*val indicatorData = LineDataSet(indicatorEntries, "SMA")
        data.setData(LineData(indicatorData))
        indicatorData.setDrawValues(false)
        indicatorData.lineWidth = 2f
        indicatorData.setCircleColor(pinkColor)
        indicatorData.color = pinkColor
        indicatorData.setDrawCircles(false)*/

        val chart = binding.candleChart
        chart.xAxis.axisMaximum = candleEntries.size + 10.toFloat()
        chart.legend.isEnabled = false
        chart.description.isEnabled = false
        chart.axisLeft.isEnabled = false
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        chart.xAxis.textColor = Color.WHITE
        chart.axisRight.textColor = Color.WHITE
        chart.data = data
        chart.invalidate()

    }


    private fun bindSymbolDetails(symbolDetails: SymbolDetails) {
        val regex = Regex(pattern = "-")
        ("%,.2f".format(symbolDetails.markChangeInDouble) + " (" + "%,.2f".format(symbolDetails.markPercentChangeInDouble) + "%)")
        binding.symbolView.text = symbolDetails.symbol
        binding.descriptionTv.text =
            (symbolDetails.description + " - " + symbolDetails.exchangeName)
        binding.bidTv.text = (" Bid: $${"%,.2f".format(symbolDetails.bidPrice)}")
        binding.lastTv.text = ("$" + "%,.2f".format(symbolDetails.mark))
        binding.askTv.text = ("Ask: $${"%,.2f".format(symbolDetails.askPrice)}")

        if (viewModel.accountDetailsLiveData.value != null) {
            val posDetails =
                viewModel.accountDetailsLiveData.value?.data?.securitiesAccount!!.positions[viewModel.positionIndex!!]
            val plOpen =
                ("%,.2f".format(((symbolDetails.mark!! - posDetails.averagePrice) * posDetails.longQuantity)))
            binding.plTv.text = plOpen
            when {
                regex.containsMatchIn(plOpen) -> {
                    binding.plTv.setTextColor(resources.getColor(R.color.colorDown))
                }
                symbolDetails.regularMarketNetChange != 0.0 -> {

                    binding.plTv.setTextColor(resources.getColor(R.color.colorUp))
                }
                else -> {
                }
            }
        }


        binding.changeTv.text =
            ("%,.2f".format(symbolDetails.markChangeInDouble) + " (" + "%,.2f".format(symbolDetails.markPercentChangeInDouble) + "%)")



        when {
            regex.containsMatchIn(symbolDetails.regularMarketNetChange.toString()) -> {
                println("first")
                binding.changeTv.setTextColor(resources.getColor(R.color.colorDown))
            }
            symbolDetails.regularMarketNetChange != 0.0 -> {
                println("second")

                binding.changeTv.setTextColor(resources.getColor(R.color.colorUp))
            }
            else -> {
                println("last")
                binding.changeTv.text =
                    ("%,.2f".format(symbolDetails.markChangeInDouble) + " (" + "%,.2f".format(
                        symbolDetails.markPercentChangeInDouble
                    ) + "%)")
            }
        }


    }

    private fun setUpObservers() {
        viewModel.chartHasPositionLiveData.observe(viewLifecycleOwner, {

            if (it == true) {
                binding.posLayout.visibility = VISIBLE
            } else {
                binding.posLayout.visibility = GONE
            }
        })

        viewModel.accountDetailsLiveData.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.loadingBarDetail.visibility = GONE
                    var posQty =
                        it.data!!.securitiesAccount.positions[viewModel.positionIndex!!].longQuantity
                    binding.qtyTv.text = posQty.toString()
                    binding.avgPriceTv.text =
                        it.data.securitiesAccount.positions[viewModel.positionIndex!!].averagePrice.toString()
                    if (binding.qtyTv.text.isNotBlank()) {
                        binding.qtyTv.setTextColor(resources.getColor(R.color.colorUp))
                    }
                    binding.qtyLayout.setOnClickListener {
                        binding.sharesInputText.setText(posQty.toInt().toString())
                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.loadingBarDetail.visibility = View.VISIBLE
            }

        }



        viewModel.symbolLiveData.observe(viewLifecycleOwner, {

            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.loadingBarDetail.visibility = GONE
                    if (!it.data.isNullOrEmpty())
                        bindSymbolDetails(it.data.values.last())
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.loadingBarDetail.visibility = View.VISIBLE
            }
        })



        viewModel.chartMediatorLiveData.observe(viewLifecycleOwner, {
            //throw exception
            if (viewModel.candleEntries.isNotEmpty()) {
                viewModel.historicalLiveData.value?.let { it1 -> setUpCandleChart(it, it1) }
            }
        })
        //we need to set up chart.
        viewModel.historicalLiveData.observe(viewLifecycleOwner, {
            if (viewModel.candleEntries.isNotEmpty()) {
                setUpCandleChart(viewModel.candleEntries, it)
            }
        })
    }


    init {
        lifecycleScope.launchWhenResumed {

            //if we navigate from chart, cancel coroutine for that previous symbol.
            println("CHECK LIFECYCLE SCOPE " + (isActive && this@ChartFragment.isAdded && isMarketDay))
            if (isActive && this@ChartFragment.isAdded && isMarketDay) {
                viewModel.getSymbolDetails()
                delay(4000)
            }
            //call once.
        }
    }

}

