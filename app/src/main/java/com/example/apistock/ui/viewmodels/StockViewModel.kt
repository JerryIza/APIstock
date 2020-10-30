package com.example.apistock.ui.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apistock.api.MarketMovers
import com.example.apistock.api.StockApiService
import com.example.apistock.api.StockRepo
import com.example.apistock.utils.Resource
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


class StockViewModel : ViewModel( ) {

    //create the job, which implements coroutines context.
    private val parentJob = Job()
    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Main
    //create a coroutine Scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)
    //initialize stock repo
    private val stockRepository : StockRepo = StockRepo(StockApiService.stockApi)
    //live data that will be populated as stock updates.
    val stockLiveData = MutableLiveData<Resource<MutableList<MarketMovers>>>()


    //we have to call this function in scope, because getStockDetails is a suspending function
    fun getStockDetails() {
        scope.launch {
            //get latest stock details from stock repo
            val moversDetail = stockRepository.getMarketMoversDetails()
            //post the value inside live data
            stockLiveData.postValue(moversDetail)
            Timber.tag("getStockDetailsExecute")
        }
    }

    fun cancelRequest() = coroutineContext.cancel()

    //Not advisable to hit server every 1-5 seconds, since server can take a few seconds to respond. Therefore leading to too many queued request.
    fun autoRefreshResults(): Job {
        return scope.launch {
            while (isActive){
                getStockDetails()
                delay(10000)
            }
        }
    }

}
