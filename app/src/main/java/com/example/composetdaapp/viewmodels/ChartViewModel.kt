package com.example.composetdaapp.ui.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apistock.utils.ToCandleEntries
import com.example.composetdaapp.data.api.MainRepository
import com.example.composetdaapp.data.entities.account.Accounts
import com.example.composetdaapp.data.entities.orders.get.GetOrderItem
import com.example.composetdaapp.data.entities.orders.place.PlaceOrder
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.data.entities.quotes.SymbolSearch
import com.example.composetdaapp.data.entities.websocket.response.Content
import com.example.composetdaapp.data.entities.websocket.response.DataResponse
import com.example.composetdaapp.utils.Resource
import com.example.composetdaapp.utils.SocketInteractor
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.consumeEach
import org.json.JSONObject
import timber.log.Timber
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZoneId
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext


@HiltViewModel
class ChartViewModel @Inject constructor(
    private val repository: MainRepository,
) : ViewModel() {

    //ADD RESOURCE TO ALL VAR/VAL

    private var job = Job()

    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    val chartMediatorLiveData = MediatorLiveData<MutableList<CandleEntry>>()

    val symbolLiveData = MutableLiveData<Resource<MutableMap<String?, SymbolDetails>>>()

    var historicalLiveData: MutableLiveData<List<Entry>> = MutableLiveData()

    var candleEntries: MutableList<CandleEntry> = ArrayList()

    private val webSocketLiveDataTest = MutableLiveData<MutableMap<String, Content>>()

    var indicatorEntries: List<Entry> = ArrayList()

    var searchResultsLiveData: MutableLiveData<MutableMap<String, SymbolSearch>> = MutableLiveData()

    var accountDetailsLiveData = MutableLiveData<Resource<Accounts>>()

    var chartHasPositionLiveData = MutableLiveData<Boolean>()

    //could be a problem with multiple position
    var positionIndex: Int? = 0

    private var posSymbols = mutableListOf<String>()

    val tickerSymbol = MutableLiveData<String>()

    var ordersLiveData = MutableLiveData<Resource<List<GetOrderItem>>>()

    fun start(symbol: String) {
        tickerSymbol.value = symbol
        //Timber.tag(("Start Symbol = " + _symbol.value))
    }


    /*fun getPosPL(symbol: String){
        if (chartHasPositionLiveData.value == true){
            accountDetailsLiveData.value.data.securitiesAccount.positions.indexOf(symbol)
        }
    }*/

    /*fun checkForPosition(symbol: String):Boolean{
        for (i in accPositions.indices){
            if(symbol.contains(accPositions[i].toString()))
            {
                return true;
            }

        }

    }*/


    fun isMarketOpen(): Boolean {
        val weekend: Set<DayOfWeek> = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)
        val zone = ZoneId.of("America/Chicago")
        val today: LocalDate = LocalDate.now(zone)
        val dayOfWeek = today.dayOfWeek
        println("CHECK WEEEKEND " + weekend.contains(dayOfWeek))
        return !weekend.contains(dayOfWeek)

    }

    fun marketOpenToMilli(): Long {
        val calendar: Calendar = Calendar.getInstance();
        calendar.time = Calendar.getInstance().time;
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        return calendar.time.toInstant().toEpochMilli();
    }

    fun marketCloseToMilli(): Long {
        val calendar: Calendar = Calendar.getInstance();
        calendar.time = Calendar.getInstance().time;
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        return calendar.time.toInstant().toEpochMilli();
    }


    fun getSearchResults(symbol: String) {
        scope.launch {
            val searchResults = repository.getSearchResults(symbol)
            if (!searchResults.data.isNullOrEmpty()) {
                searchResultsLiveData.postValue(searchResults.data)
            }
        }
    }


    fun getAccountDetails(symbol: String) {
        scope.launch {
            val accDetails = repository.getAccountDetails()
            accountDetailsLiveData.postValue(accDetails)
            val accPositions = (accDetails.data?.securitiesAccount?.positions)
            for (i in accPositions!!.indices) {
                posSymbols.add(accPositions[i].instrument.symbol)
                if (accPositions[i].instrument.symbol == symbol) {
                    positionIndex = i
                }
            }

            chartHasPositionLiveData.postValue(posSymbols.contains(symbol))
        }
    }

    fun getAllOrders() {
        scope.launch {
            val accOrders = repository.getOrders()
            ordersLiveData.postValue(accOrders)
        }
    }


    fun placeOrder(order: PlaceOrder) {
        scope.launch {
            val a = repository.placeOrder("Account #", order)
        }
    }


    fun getSymbolDetails() {
        scope.launch {
            val symbolDetails = repository.getSymbolDetails(tickerSymbol.value.toString())
            symbolLiveData.postValue(symbolDetails)
        }
    }


    fun getChartData(periodType: String, period: String, frequency: String) {
        scope.launch {
            val historicalData = repository.getHistoricalData(
                tickerSymbol.value.toString(),
                periodType,
                period,
                frequency
            )
            try {
                //adding symbols details
                chartMediatorLiveData.addSource(symbolLiveData) {
                    if (candleEntries.isEmpty()) {
                        Timber.v("CANDLE ENTRY EMPTY BOY")
                        scope.launch {
                            candleEntries = ToCandleEntries.toCandleEntry(historicalData)
                            historicalLiveData.postValue((candleEntries))
                        }
                    }

                    when (historicalData.status) {
                        Resource.Status.SUCCESS -> {


                            val historicalDataSize = (historicalData.data!!.candles.lastIndex + 1)
                            //remove and update today's candle.

                            chartMediatorLiveData.value = ToCandleEntries.lastCandleUpdate(
                                candleEntries = candleEntries,
                                symbolDetails = it.data!!.values.last(),
                                historicalDataSize = historicalDataSize
                            )

                        }
                        Resource.Status.ERROR -> Timber.e(historicalData.message)
                        Resource.Status.LOADING -> Timber.v("Loading Chart Data")
                    }
                }
            } catch (e: IllegalArgumentException) {
                chartMediatorLiveData.removeSource(symbolLiveData)
            }
        }
    }
   //TODO solve intra-day updates and implement SMA indicator
    fun getIntraDayChartData(startDate: String, endDate: String) {
        scope.launch {

            val historicalData = repository.getIntraDayHistorical(
                tickerSymbol.value.toString(),
                startDate,
                endDate,
                "true"
            )/*
            val historicalData2 = repository.getHistoricalData(
                _symbol.value.toString(),
                "year",
                "2",
                frequency
            )*/
            try {
                chartMediatorLiveData.addSource(symbolLiveData) {
                    if (candleEntries.isEmpty()) {
                        Timber.v("Chart Empty, Set up chart")
                        scope.launch {
                            candleEntries = ToCandleEntries.toCandleEntry(historicalData)
                            historicalLiveData.postValue((candleEntries))
                        }
                    }

                    when (historicalData.status) {
                        Resource.Status.SUCCESS -> {
                            val historicalDataSize = (historicalData.data!!.candles.lastIndex + 1)
                            //remove and update today's candle.

                            chartMediatorLiveData.value = ToCandleEntries.lastCandleUpdate(
                                candleEntries = candleEntries,
                                symbolDetails = it.data!!.values.last(),
                                historicalDataSize = historicalDataSize
                            )

                        }
                        Resource.Status.ERROR -> Timber.e(historicalData.message)
                        Resource.Status.LOADING -> Timber.v("Loading Chart Data")
                    }
                }
            } catch (e: IllegalArgumentException) {
                chartMediatorLiveData.removeSource(symbolLiveData)
            }
        }
    }

}


