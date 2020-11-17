package com.example.apistock.utils

import com.example.apistock.data.entities.HistoricalData
import com.github.mikephil.charting.data.CandleEntry


object ToCandleEntries {

    fun toCandleEntry (candle: Resource<HistoricalData>): MutableList<CandleEntry>{
        val candleEntries: MutableList<CandleEntry> = ArrayList()
        for (i in candle.data!!.candles.indices) {
            candleEntries.add(
                CandleEntry(
                    i.toFloat(),
                    candle.data.candles[i].high.toFloat(),
                    candle.data.candles[i].low.toFloat(),
                    candle.data.candles[i].open.toFloat(),
                    candle.data.candles[i].close.toFloat()
                )
            )
        }
        return candleEntries
    }
}