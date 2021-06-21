package com.example.apistock.utils

import com.example.apistock.data.entities.quotes.HistoricalData
import com.example.apistock.data.entities.quotes.SymbolDetails
import com.github.mikephil.charting.data.CandleEntry
import timber.log.Timber


object ToCandleEntries {


//if no connection it crashes throw exception
    fun toCandleEntry (historicalData: Resource<HistoricalData>): MutableList<CandleEntry>{
        val candleEntries: MutableList<CandleEntry> = ArrayList()
    try {
        for (i in historicalData.data!!.candles.indices) {
            Timber.i("Response to Candle Executed")
            candleEntries.add(
                CandleEntry(
                    i+1.toFloat(),
                    historicalData.data.candles[i].high.toFloat(),
                    historicalData.data.candles[i].low.toFloat(),
                    historicalData.data.candles[i].open.toFloat(),
                    historicalData.data.candles[i].close.toFloat()
                )
            )
        }
    }catch (e: NullPointerException){}
        return candleEntries
    }
    //remove and update today's candle.
    fun lastCandleUpdate(candleEntries: MutableList<CandleEntry>, symbolDetails: SymbolDetails, historicalDataSize: Int ): MutableList<CandleEntry>{
        if (candleEntries.size > historicalDataSize) {
            Timber.i("Update Last Candle")
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
        }else{
            //don't show candle unless it's regular session like the TD app
            Timber.i("Add Last Candle For the First Time")
                symbolDetails.lowPrice.toFloat()+
                symbolDetails.openPrice.toFloat()+
                symbolDetails.lastPrice.toFloat())
            candleEntries.add(
                CandleEntry(
                    candleEntries.size.toFloat()+ 1,
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
