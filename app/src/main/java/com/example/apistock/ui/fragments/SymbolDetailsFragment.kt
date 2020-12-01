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
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.apistock.R
import com.example.apistock.data.entities.SymbolDetails
import com.example.apistock.databinding.SymbolDetailsFragmentBinding
import com.example.apistock.indicators.UpperIndicators
import com.example.apistock.ui.viewmodels.MarketMoversViewModel
import com.example.apistock.utils.Resource
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.symbol_details_fragment.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import timber.log.Timber


class SymbolDetailsFragment : Fragment() {


    private lateinit var binding: SymbolDetailsFragmentBinding

    private val viewModel: MarketMoversViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SymbolDetailsFragmentBinding.inflate(inflater, container, false)
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

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.chartLiveData.removeSource(viewModel.symbolLiveData)
        //Clearing previous candle candleEntries.
        viewModel.candleEntries = ArrayList()
        viewModel.indicatorEntries = ArrayList()
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

    private fun bindSymbolDetails(symbolDetails: SymbolDetails) {
        val regex = Regex(pattern = "-")
        binding.changeTv.text =
            (if (regex.containsMatchIn(symbolDetails.markChangeInDouble.toString())) {
                binding.changeTv.setTextColor(resources.getColor(R.color.colorDown))
                ("%,.2f".format(symbolDetails.markChangeInDouble) + " (" + "%,.2f".format(
                    symbolDetails.markPercentChangeInDouble
                ) + "%)")
            } else {
                binding.changeTv.setTextColor(resources.getColor(R.color.colorUp))
                ("%,.2f".format(symbolDetails.markChangeInDouble) + " (" + "%,.2f".format(
                    symbolDetails.markPercentChangeInDouble
                ) + "%)")
            })
        binding.symbolView.text = symbolDetails.symbol
        binding.descriptionTv.text = (symbolDetails.description + " - " + symbolDetails.exchangeName)
        binding.lowTv.text = ("$${symbolDetails.wkLow}")
        binding.highTv.text = ("$${symbolDetails.wkHigh}")
        binding.bidTv.text = (" Bid: $${symbolDetails.bidPrice}")
        binding.lastTv.text = ("$" + "%,.2f".format(symbolDetails.lastPrice))
        binding.askTv.text = ("Ask: $${symbolDetails.askPrice}")
        binding.volumeTv.text = ("%,d".format(symbolDetails.totalVolume) + " Shares")
        binding.peRatioTv.text = ("%,.2f".format(symbolDetails.peRatio) + "X")
        if (symbolDetails.marginable) {
            binding.marginableTv.text = getString(R.string._yes)
        } else {
            binding.marginableTv.text = getString(R.string._no)
        }
        if (symbolDetails.shortable) {
            binding.shortableTv.text = getString(R.string._yes)
        } else {
            binding.shortableTv.text = getString(R.string._no)
        }
        binding.highLowProgressBar.progress = viewModel.get52WeekHighLow(
            symbolDetails.lastPrice,
            symbolDetails.wkLow,
            symbolDetails.wkHigh
        )

    }


    private fun setUpCandleChart(candleEntries: MutableList<CandleEntry>, indicatorEntries: List<Entry>) {

        val pinkColor = Color.parseColor("#FE657A")

        val data = CombinedData()

        val chartData = CandleDataSet(candleEntries, "")
        data.setData(CandleData(chartData))
        chartData.color = Color.rgb(80, 80, 80)
        chartData.shadowColor = Color.WHITE
        chartData.shadowWidth = 0.7f
        chartData.decreasingColor = Color.RED
        chartData.decreasingPaintStyle = Paint.Style.FILL
        chartData.increasingColor = Color.rgb(122, 242, 84)
        chartData.increasingPaintStyle = Paint.Style.FILL
        chartData.neutralColor = Color.BLUE
        chartData.valueTextSize = 0f


        val indicatorData = LineDataSet(indicatorEntries, "SMA")
        data.setData(LineData(indicatorData))
        indicatorData.setDrawValues(false)
        indicatorData.lineWidth = 2f
        indicatorData.setCircleColor(pinkColor)
        indicatorData.color = pinkColor
        indicatorData.setDrawCircles(false)

        val chart = binding.candleChart
        chart.xAxis.axisMaximum = candleEntries.size+10.toFloat()
        chart.legend.isEnabled = false
        chart.description.isEnabled = false
        chart.axisLeft.isEnabled = false
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        chart.xAxis.textColor = Color.WHITE
        chart.axisRight.textColor = Color.WHITE
        chart.data = data
        chart.invalidate()

    }

    init {
        lifecycleScope.launchWhenCreated {
            //if we navigate from chart, cancel coroutine for that previous symbol.
            while (isActive && this@SymbolDetailsFragment.isAdded) {
                viewModel.getSymbolDetails()
                delay(10000)
            }
        }
    }

}

