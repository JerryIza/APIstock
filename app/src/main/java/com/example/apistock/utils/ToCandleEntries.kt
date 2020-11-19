package com.example.apistock.utils

import com.example.apistock.data.entities.HistoricalData
import com.example.apistock.data.entities.SymbolDetails
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
    //remove and update today's candle.
    fun lastCandleUpdate(candleEntries: MutableList<CandleEntry>, symbolDetails: SymbolDetails): MutableList<CandleEntry>{
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
        }else{
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
        return candleEntries
    }
}