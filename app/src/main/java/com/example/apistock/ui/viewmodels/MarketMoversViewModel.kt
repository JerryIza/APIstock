package com.example.apistock.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apistock.data.entities.MarketMovers
import com.example.apistock.data.api.StockApiService
import com.example.apistock.data.api.SymbolRepo
import com.example.apistock.data.entities.HistoricalData
import com.example.apistock.data.entities.SymbolDetails
import com.example.apistock.utils.Resource
import com.example.apistock.utils.ToCandleEntries
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


class MarketMoversViewModel : ViewModel() {

    var isSelected = true

    var isSelected2 = false

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

    //symbolDetails
    val symbolLiveData = MutableLiveData<Resource<MutableMap<String?, SymbolDetails>>>()

    val chartLiveData = MutableLiveData<Resource<HistoricalData>>()

    fun start(symbol : String){
        _symbol.value = symbol
        Timber.tag(("Start Symbol = " + _symbol.value))
    }

    fun cancelRequest() = job.cancel()

    fun getHistoricalData() {
        scope.launch {
            val historicalData = symbolRepository.getHistoricalData(_symbol.value.toString())
            chartLiveData.postValue(historicalData)
        }
    }

    //we have to call this function in scope, because getMoversDetails is a suspending function
    fun getMoversDetails() {
        scope.launch {
            val moversDetail = symbolRepository.getMarketMoversDetails()
            moversLiveData.postValue(moversDetail)
        }
    }

     fun getSymbolDetails() {
        scope.launch {
            val symbolDetails = symbolRepository.getSymbolDetails(_symbol.value.toString())
            symbolLiveData.postValue(symbolDetails)
        }
    }



    fun autoRefreshSymbolDetails(): Job {
        return scope.launch {
            while (isActive && isSelected2) {
                getSymbolDetails()
                delay(10000)
            }
        }
    }

    init {
        viewModelScope.launch {

        }
    }

}
