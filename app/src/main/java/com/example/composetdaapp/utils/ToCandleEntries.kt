package com.example.apistock.utils

import com.example.composetdaapp.data.entities.quotes.HistoricalData
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.utils.Resource
import com.github.mikephil.charting.data.CandleEntry


object ToCandleEntries {


//if no connection it crashes throw exception
    fun toCandleEntry (historicalData: Resource<HistoricalData>): MutableList<CandleEntry>{
        val candleEntries: MutableList<CandleEntry> = ArrayList()
    try {
        for (i in historicalData.data!!.candles.indices) {
            //Timber.i("Response to Candle Executed")
                println("Response to Candle Executed")
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
            //use timber
                println("Update Last Candle")
            println("Response to Candle Executed" +candleEntries)

            println("Response to Candle Executed" + candleEntries.last())
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

            //ohlc doesn't show up in ext sessions
                //might need to use websocket
            println("Add Last Candle For the First Time")
                /*
                tf does this do?

                symbolDetails.lowPrice.toFloat()+
                symbolDetails.openPrice.toFloat()+
                symbolDetails.lastPrice.toFloat()*/
            candleEntries.add(
                CandleEntry(
                    candleEntries.size.toFloat()+ 1,
                    symbolDetails.highPrice.toFloat(),
                    symbolDetails.lowPrice.toFloat(),
                    symbolDetails.openPrice.toFloat(),
                    symbolDetails.mark!!.toFloat()
                )
            )

        }
        return candleEntries
    }
}
