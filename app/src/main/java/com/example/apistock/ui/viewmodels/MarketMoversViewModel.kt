package com.example.apistock.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apistock.data.api.StockApiService
import com.example.apistock.data.api.SymbolRepo
import com.example.apistock.data.entities.HistoricalData
import com.example.apistock.data.entities.MarketMovers
import com.example.apistock.data.entities.SymbolDetails
import com.example.apistock.utils.Resource
import com.example.apistock.utils.ToCandleEntries
import com.github.mikephil.charting.data.CandleEntry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


class MarketMoversViewModel : ViewModel() {

    //create the job, which implements coroutines context.
    var job = Job()

    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    //create a coroutine Scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)

    //initialize stock repo
    private val symbolRepository: SymbolRepo = SymbolRepo(StockApiService.stockApi)

    //input symbol
    private val _symbol = MutableLiveData<String>()

    //live data that will be populated as stock updates.
    val moversLiveData = MutableLiveData<Resource<MutableList<MarketMovers>>>()

    //LiveData1
    val symbolLiveData = MutableLiveData<Resource<MutableMap<String?, SymbolDetails>>>()

    //LiveData2
    private val historicalLiveData = MutableLiveData<Resource<HistoricalData>>()

    //two different paths needed to build our chart, therefore two instances of live data.
    val chartLiveData = MediatorLiveData<MutableList<CandleEntry>>()

    private var candleEntries: MutableList<CandleEntry> = ArrayList()


    fun start(symbol: String) {
        _symbol.value = symbol
        Timber.tag(("Start Symbol = " + _symbol.value))
    }

    fun getHistoricalData() {
        scope.launch {
            val historicalData = symbolRepository.getHistoricalData(_symbol.value.toString())
            historicalLiveData.postValue(historicalData)

            //add one source only, because historical data only needs to be called once per symbol.
            chartLiveData.addSource(symbolLiveData) {
                candleEntries = ToCandleEntries.toCandleEntry(historicalData)
                //remove and update today's candle.
                chartLiveData.value = ToCandleEntries.lastCandleUpdate(candleEntries, it.data?.values!!.last())
                }
            }
        }

        fun getSymbolDetails() {
            scope.launch {
                val symbolDetails = symbolRepository.getSymbolDetails(_symbol.value.toString())
                symbolLiveData.postValue(symbolDetails)
            }
        }

        //we have to call this function in scope, because getMoversDetails is a suspending function
        fun getMoversDetails() {
            scope.launch {
                val moversDetail = symbolRepository.getMarketMoversDetails()
                moversLiveData.postValue(moversDetail)
            }
        }


        //make test
        fun get52WeekHighLow(last: Double, low: Double, high: Double) =
            (((last - low) / (high - low)) * 100).toInt()

    }
