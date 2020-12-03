package com.example.apistock.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apistock.data.api.SymbolRepo
import com.example.apistock.data.entities.HistoricalData
import com.example.apistock.data.entities.MarketMovers
import com.example.apistock.data.entities.SymbolDetails
import com.example.apistock.data.entities.SymbolSearch
import com.example.apistock.indicators.UpperIndicators
import com.example.apistock.utils.Resource
import com.example.apistock.utils.ToCandleEntries
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


class MarketMoversViewModel @ViewModelInject constructor(private val repository: SymbolRepo) :
    ViewModel() {

    //create the job, which implements coroutines context.
    var job = Job()

    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    private val _symbol = MutableLiveData<String>()

    val moversLiveData = MutableLiveData<Resource<MutableList<MarketMovers>>>()

    val symbolLiveData = MutableLiveData<Resource<MutableMap<String?, SymbolDetails>>>()

    var upperIndicators = UpperIndicators()

    val chartLiveData = MediatorLiveData<MutableList<CandleEntry>>()

    var candleEntries: MutableList<CandleEntry> = ArrayList()

    var indicatorEntries: List<Entry> = ArrayList()

    var indicatorLiveData: MutableLiveData<List<Entry>> = MutableLiveData()

    var searchResultsLiveData: MutableLiveData<MutableMap<String, SymbolSearch>> = MutableLiveData()


    fun start(symbol: String) {
        _symbol.value = symbol
        Timber.tag(("Start Symbol = " + _symbol.value))
    }



    fun getChartData(periodType: String, period: String, frequency: String) {
        scope.launch {
            val historicalData = repository.getHistoricalData(
                _symbol.value.toString(),
                periodType,
                period,
                frequency
            )
            val historicalData2 = repository.getHistoricalData(
                _symbol.value.toString(),
                "year",
                "2",
                frequency
            )
            try {
                chartLiveData.addSource(symbolLiveData) {
                    if (candleEntries.isEmpty()) {
                        scope.launch {
                            indicatorLiveData.postValue(getIndicatorData(historicalData2))
                        }
                    }

                    if (candleEntries.isEmpty()) {
                        candleEntries = ToCandleEntries.toCandleEntry(historicalData)
                    }

                    val historicalDataSize = (historicalData.data!!.candles.lastIndex + 1)
                    //remove and update today's candle.
                    chartLiveData.value = ToCandleEntries.lastCandleUpdate(
                        candleEntries,
                        it.data?.values!!.last(),
                        historicalDataSize
                    )
                }
            } catch (e: IllegalArgumentException) {
                chartLiveData.removeSource(symbolLiveData)
            }
        }
    }

    /*
    Indicators need more data than what is originally requested, in order to be calculated properly.
     */
    private suspend fun getIndicatorData(historicalData: Resource<HistoricalData>): List<Entry> {
        val results = CompletableDeferred<List<Entry>>()
        withContext(Dispatchers.IO) {
            results.complete(
                upperIndicators.simpleMovingAverage(
                    historicalData,
                    50,
                    candleEntries.size
                )
            )
        }
        return results.await()
    }

    fun getSearchResults(symbol: String) {
        scope.launch {
            val searchResults = repository.getSearchResults(symbol)
            searchResultsLiveData.postValue(searchResults.data)
        }
    }

    fun getSymbolDetails() {
        scope.launch {
            val symbolDetails = repository.getSymbolDetails(_symbol.value.toString())
            symbolLiveData.postValue(symbolDetails)
        }
    }

    fun getMoversDetails(market: String) {
        scope.launch {
            val moversDetail = repository.getMarketMoversDetails(market)
            moversLiveData.postValue(moversDetail)
        }
    }

    //make test
    fun get52WeekHighLow(last: Double, low: Double, high: Double) =
        (((last - low) / (high - low)) * 100).toInt()

}
