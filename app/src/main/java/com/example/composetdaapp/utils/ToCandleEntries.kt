package com.example.apistock.utils

import com.example.composetdaapp.data.entities.quotes.HistoricalData
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.utils.Resource
import com.github.mikephil.charting.data.CandleEntry
import timber.log.Timber


object ToCandleEntries {


//if no connection it crashes throw exception
    fun toCandleEntry (historicalData: Resource<HistoricalData>): MutableList<CandleEntry>{
        val candleEntries: MutableList<CandleEntry> = ArrayList()
    try {
        for (i in historicalData.data!!.candles.indices) {
            candleEntries.add(
                CandleEntry(
                    i+1.toFloat(),
                    historicalData.data.candles[i].high.toFloat(),
                    historicalData.data.candles[i].low.toFloat(),
                    historicalData.data.candles[i].open.toFloat(),
                    historicalData.data.candles[i].close.toFloat()
                )
            )
            Timber.v("ToCandle setup historical ${candleEntries.last()}")

        }
    }catch (e: NullPointerException){}
        return candleEntries
    }
    //remove and update today's candle.
    fun lastCandleUpdate(candleEntries: MutableList<CandleEntry>, symbolDetails: SymbolDetails, historicalDataSize: Int ): MutableList<CandleEntry>{
        if (candleEntries.size > historicalDataSize) {
            //use timber
            candleEntries.removeLast()
            candleEntries.add(
                CandleEntry(
                    candleEntries.size.toFloat() + 1,
                    symbolDetails.highPrice.toFloat(),
                    symbolDetails.lowPrice.toFloat(),
                    symbolDetails.openPrice.toFloat(),
                   symbolDetails.lastPrice.toFloat()
                )
            )
            Timber.v("ToCandle replace last%s ", candleEntries.last())

        }else{

            candleEntries.add(
                CandleEntry(
                    candleEntries.size.toFloat()+ 1,
                    symbolDetails.highPrice.toFloat(),
                    symbolDetails.lowPrice.toFloat(),
                    symbolDetails.openPrice.toFloat(),
                    symbolDetails.mark!!.toFloat()
                )
            )
            Timber.v("ToCandle add last ${candleEntries.last()}")

        }
        return candleEntries
    }
}
