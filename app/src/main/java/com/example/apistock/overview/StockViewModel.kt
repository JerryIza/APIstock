package com.example.apistock.overview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apistock.api.*

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext



class StockViewModel : ViewModel( ) {

    //create the job, which implements coroutines context.
    private val parentJob = Job()
    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Main
    //create a coroutine Scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)
    //initialize stock repo
    val stockRepository : StockRepo = StockRepo(StockApiService.stockApi)
    //live data that will be populated as stock updates.
    val stockLiveData = MutableLiveData<MutableList<SymbolDetails>>()



    //we have to call this function in scope, because getStockDetails is a suspending function
    fun getStockDetails() {
        scope.launch {
            //get latest stock details from stock repo
            val symbolDetails = stockRepository.getStockDetails()
            //post the value inside live data.g
            stockLiveData.postValue(symbolDetails)
        }
    }
    fun cancelRequest() = coroutineContext.cancel()
}
