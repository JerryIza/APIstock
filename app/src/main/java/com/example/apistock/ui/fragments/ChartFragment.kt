package com.example.apistock.ui.fragments

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.apistock.R
import com.example.apistock.data.entities.quotes.SymbolDetails
import com.example.apistock.databinding.ChartFragmentBinding
import com.example.apistock.ui.MainActivity
import com.example.apistock.ui.viewmodels.MarketViewModel
import com.example.apistock.utils.Resource
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import kotlinx.android.synthetic.main.chart_fragment.*
import kotlinx.android.synthetic.main.dashboard_fragment.view.*
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_activity.view.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive




class ChartFragment : Fragment() {


    private lateinit var binding: ChartFragmentBinding

    private val viewModel: MarketViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChartFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        viewModel.getChartData("year", "1", "daily")


        binding.monthBtn.setOnClickListener {
            viewModel.chartLiveData.removeSource(viewModel.symbolLiveData)
            viewModel.candleEntries = ArrayList()
            viewModel.getChartData("month", "1", "daily")

        }

        binding.threeMonthBtn.setOnClickListener {
            viewModel.chartLiveData.removeSource(viewModel.symbolLiveData)
            viewModel.candleEntries = ArrayList()
            viewModel.getChartData("month", "3", "daily")
        }

        binding.sixMonthsBtn.setOnClickListener {
            viewModel.chartLiveData.removeSource(viewModel.symbolLiveData)
            viewModel.candleEntries = ArrayList()
            viewModel.getChartData("month", "6", "daily")
        }

        binding.oneYearBtn.setOnClickListener {
            viewModel.chartLiveData.removeSource(viewModel.symbolLiveData)
            viewModel.candleEntries = ArrayList()
            viewModel.getChartData("year", "1", "daily")
        }


        binding.btnBuy.setOnClickListener {
            motionLayout.transitionToEnd()
        }

        binding.btnSell.setOnClickListener {
            motionLayout.transitionToEnd()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.chartLiveData.removeSource(viewModel.symbolLiveData)
        //Clearing previous candle candleEntries.
        viewModel.candleEntries = ArrayList()
        viewModel.indicatorEntries = ArrayList()
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


        val indicatorData = LineDataSet(indicatorEntries, "SMA")
        data.setData(LineData(indicatorData))
        indicatorData.setDrawValues(false)
        indicatorData.lineWidth = 2f
        indicatorData.setCircleColor(pinkColor)
        indicatorData.color = pinkColor
        indicatorData.setDrawCircles(false)

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
        binding.lastTv.text = ("$" + "%,.2f".format(symbolDetails.lastPrice))
        binding.askTv.text = ("Ask: $${"%,.2f".format(symbolDetails.askPrice)}")

        binding.changeTv.text = ("%,.2f".format(symbolDetails.markChangeInDouble) + " (" + "%,.2f".format(symbolDetails.markPercentChangeInDouble) + "%)")



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
                binding.changeTv.text = ("%,.2f".format(symbolDetails.markChangeInDouble) + " (" + "%,.2f".format(symbolDetails.markPercentChangeInDouble) + "%)")
            }
        }


    }




    private fun setUpObservers() {
        viewModel.symbolLiveData.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.loadingBarDetail.visibility = View.GONE
                    if (!it.data.isNullOrEmpty())
                        bindSymbolDetails(it.data.values.last())
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.loadingBarDetail.visibility = View.VISIBLE
            }
        })

        viewModel.chartLiveData.observe(viewLifecycleOwner, {
            viewModel.indicatorLiveData.value?.let { it1 -> setUpCandleChart(it, it1) }

        })

        viewModel.indicatorLiveData.observe(viewLifecycleOwner, {
            if (viewModel.candleEntries.isNotEmpty()) {
                setUpCandleChart(viewModel.candleEntries, it)
            }
        })
    }



    init {
        lifecycleScope.launchWhenCreated {
            //if we navigate from chart, cancel coroutine for that previous symbol.
            while (isActive && this@ChartFragment.isAdded) {
                viewModel.getSymbolDetails()
                delay(10000)
            }
        }
    }

}

