package com.example.apistock.indicators

import com.example.apistock.data.entities.HistoricalData
import com.example.apistock.utils.Resource
import com.github.mikephil.charting.data.Entry

class UpperIndicators {

    fun simpleMovingAverage(
        historicalData: Resource<HistoricalData>,
        length: Int,
        size: Int
    ): List<Entry> {
        val chartData = ArrayList<Double>()
        for (i in historicalData.data!!.candles.indices) {
            chartData.add(
                historicalData.data.candles[i].close
            )
        }
        val simpleMovingAvg = chartData.windowed(length) { it.average() }
        val xAxisStart = (simpleMovingAvg.size-size)
        val results: MutableList<Entry> = ArrayList()
        for (i in xAxisStart.until(simpleMovingAvg.size)) {
            results.add(
                Entry(
                    (i-xAxisStart).toFloat(),
                    simpleMovingAvg[i].toFloat()
                )
            )
        }
        return results
    }


}