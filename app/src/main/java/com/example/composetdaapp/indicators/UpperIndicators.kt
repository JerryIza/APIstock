package com.example.composetdaapp.indicators

import com.example.composetdaapp.data.entities.quotes.HistoricalData
import com.example.composetdaapp.utils.Resource
import com.github.mikephil.charting.data.Entry
import timber.log.Timber

class UpperIndicators {

    fun simpleMovingAverage(
        historicalData: Resource<HistoricalData>,
        length: Int,
        size: Int
    ): List<Entry> {
        val chartData = ArrayList<Double>()
        val results: MutableList<Entry> = ArrayList()
        when (historicalData.status) {
            Resource.Status.SUCCESS -> {
                try {
                for (i in historicalData.data!!.candles.indices) {
                    chartData.add(
                        historicalData.data.candles[i].close
                    )
                }
                val simpleMovingAvg = chartData.windowed(length) { it.average() }
                val xAxisStart = (simpleMovingAvg.size - size)
                for (i in xAxisStart.until(simpleMovingAvg.size)) {
                    results.add(
                        Entry(
                            (i - xAxisStart).toFloat(),
                            simpleMovingAvg[i].toFloat()
                        )
                    )
                }
            }catch (e: IllegalArgumentException) {
                Timber.e("LOG Error here")
            }
            }
            Resource.Status.ERROR -> Timber.e(historicalData.message)
            Resource.Status.LOADING -> Timber.v("Loading")
        }
        return results
    }
}

