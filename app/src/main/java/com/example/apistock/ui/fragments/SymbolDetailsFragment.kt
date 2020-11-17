package com.example.apistock.ui.fragments

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.apistock.R
import com.example.apistock.data.entities.SymbolDetails
import com.example.apistock.databinding.SymbolDetailsFragmentBinding
import com.example.apistock.ui.viewmodels.MarketMoversViewModel
import com.example.apistock.utils.Resource
import com.example.apistock.utils.ToCandleEntries
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive


@AndroidEntryPoint
class SymbolDetailsFragment : Fragment() {

    private lateinit var binding: SymbolDetailsFragmentBinding

    private val viewModel: MarketMoversViewModel by activityViewModels()

    private var candleEntries: MutableList<CandleEntry> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SymbolDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        //because of the day aggregation we only need to fetch data once. We will however update the most recent candle every 10 seconds
        viewModel.getHistoricalData()
        println("onViewCreated")


    }


    private fun setUpObservers() {
        viewModel.symbolLiveData.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.loadingBarDetail.visibility = View.GONE
                   if (!it.data.isNullOrEmpty()) bindSymbolDetails(it.data.values.last())
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.loadingBarDetail.visibility = View.VISIBLE
            }
        })
        viewModel.chartLiveData.observe(viewLifecycleOwner, {
            candleEntries = ToCandleEntries.toCandleEntry(it)
           // setUpCandleChart(candleEntries)
            println(it.data!!.candles.size)
        })
    }

  private fun bindSymbolDetails(symbolDetails: SymbolDetails) {
        val regex = Regex(pattern = "-")
        //remove and update today's candle.
      println("Chart candles size: "+  candleEntries.size)
        if (candleEntries.size > 22) {
            candleEntries.removeLast()
            candleEntries.add(
                CandleEntry(
                    candleEntries.size.toFloat(),
                    symbolDetails.highPrice.toFloat(),
                    symbolDetails.lowPrice.toFloat(),
                    symbolDetails.openPrice.toFloat(),
                    symbolDetails.lastPrice.toFloat()
                )
            )
        } else {
            candleEntries.add(
                CandleEntry(
                    candleEntries.size.toFloat(),
                    symbolDetails.highPrice.toFloat(),
                    symbolDetails.lowPrice.toFloat(),
                    symbolDetails.openPrice.toFloat(),
                    symbolDetails.lastPrice.toFloat()
                )
            )
        }
        setUpCandleChart(candleEntries)
        binding.changeTv.text =
            (if (regex.containsMatchIn(symbolDetails.markChangeInDouble.toString())) {
                binding.changeTv.setTextColor(resources.getColor(R.color.colorDown))
                ("%,.2f".format(symbolDetails.markChangeInDouble) + "(" + "%,.2f".format(
                    symbolDetails.markPercentChangeInDouble
                ) + "%)")
            } else {
                binding.changeTv.setTextColor(resources.getColor(R.color.colorUp))
                ("%,.2f".format(symbolDetails.markChangeInDouble) + "(" + "%,.2f".format(
                    symbolDetails.markPercentChangeInDouble
                ) + "%)")
            })
        binding.symbolView.text = symbolDetails.symbol
        binding.descriptionTv.text = (symbolDetails.description + " - " + symbolDetails.exchangeName)
        binding.lowTv.text = ("$${symbolDetails.wkLow}")
        binding.highTv.text = ("$${symbolDetails.wkHigh}")
        binding.bidTv.text = (" Bid: $${symbolDetails.bidPrice}")
        binding.lastTv.text = ("$"+"%,.2f".format(symbolDetails.lastPrice))
        binding.askTv.text = ("Ask: $${symbolDetails.askPrice}")

      binding.highLowProgressBar.progress = viewModel.get52WeekHighLow(symbolDetails.lastPrice,symbolDetails.wkLow, symbolDetails.wkHigh).toInt()
        println("high and low position: "+ viewModel.get52WeekHighLow(symbolDetails.lastPrice,symbolDetails.wkLow, symbolDetails.wkHigh))
    }


    private fun setUpCandleChart(entries: MutableList<CandleEntry>) {
        val chartData = CandleDataSet(entries, "")
        chartData.color = Color.rgb(80, 80, 80)
        chartData.shadowColor = Color.WHITE
        chartData.shadowWidth = 0.7f
        chartData.decreasingColor = Color.RED
        chartData.decreasingPaintStyle = Paint.Style.FILL
        chartData.increasingColor = Color.rgb(122, 242, 84)
        chartData.increasingPaintStyle = Paint.Style.STROKE
        chartData.neutralColor = Color.BLUE
        chartData.valueTextSize = 0f
        binding.candleChart.legend.isEnabled = false
        binding.candleChart.description.isEnabled = false
        binding.candleChart.axisLeft.isEnabled = false

        binding.candleChart.data = CandleData(chartData)
        binding.candleChart.invalidate()
        binding.candleChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        binding.candleChart.xAxis.textColor = Color.WHITE
        binding.candleChart.axisRight.textColor = Color.WHITE


    }


    init {
        lifecycleScope.launchWhenCreated {
            while (isActive && this@SymbolDetailsFragment.isAdded) {
                viewModel.getSymbolDetails()
                delay(10000)
            }
        }
    }

}

