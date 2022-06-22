package com.example.composetdaapp.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apistock.utils.ToCandleEntries
import com.example.composetdaapp.data.api.MainRepository
import com.example.composetdaapp.data.entities.account.Accounts
import com.example.composetdaapp.data.entities.orders.get.GetOrderItem
import com.example.composetdaapp.data.entities.orders.place.PlaceOrder
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.data.entities.quotes.SymbolSearch
import com.example.composetdaapp.data.entities.websocket.request.DataRequest
import com.example.composetdaapp.data.entities.websocket.request.FuturesParam
import com.example.composetdaapp.data.entities.websocket.request.Request
import com.example.composetdaapp.data.entities.websocket.response.Content
import com.example.composetdaapp.data.entities.websocket.response.DataResponse
import com.example.composetdaapp.utils.LEVELONE_FUTURES
import com.example.composetdaapp.utils.MyPreference
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
    private val interactor: SocketInteractor,
    private val moshi: Moshi,
    private val repository: MainRepository,
    private val myPreference: MyPreference
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

    val webSocketLiveData = MutableLiveData<MutableMap<String, Content>>()

    val accountNumber = myPreference.getAccountNumber()


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
        Timber.i("Is Weekend: %s", weekend.contains(dayOfWeek))
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
            val accDetails = repository.getAccountDetails(myPreference.getAccountNumber())
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

    //TODO Not working when placing orders over the weekend, check request body
    fun placeOrder(order: PlaceOrder) {
        scope.launch {
            val a = repository.placeOrder(myPreference.getAccountNumber(), order)
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
                        Timber.v("CANDLE ENTRY EMPTY")
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

    private val levelOneFuturesDC = DataRequest(
        request = listOf(
            Request(
                futuresParam = FuturesParam(),
                service = LEVELONE_FUTURES,
                account = accountNumber,
                source = myPreference.getDevUserId()
            )
        )
    )

    val futuresHistory = " {\n" +
            "            \"service\": \"CHART_HISTORY_FUTURES\",\n" +
            "            \"requestid\": \"2\",\n" +
            "            \"command\": \"GET\",\n" +
            "            \"account\": \"149235993\",\n" +
            "            \"source\": \"gerardoiza94\",\n" +
            "            \"parameters\": {\n" +
            "                \"symbol\": \"/ES\",\n" +
            "                \"frequency\": \"m1\",\n" +
            "                \"period\": \"d1\"\n" +
            "            }\n" +
            "        }"

    @ExperimentalCoroutinesApi
    fun subscribeToSocketEvents() {
        viewModelScope.launch {
            val jsonAdapterRequest = moshi.adapter(Request::class.java)
            val json: String = jsonAdapterRequest.toJson(levelOneFuturesDC.request[0])
            //fun sendFuturesPayload() = interactor.sendSocketRequest(json)
            fun sendFuturesHistorical() = interactor.sendSocketRequest(futuresHistory)


            //fun sendFuturesPayload() = interactor.sendSocketRequest(chartEquity)
            try {
                val jsonAdapter = moshi.adapter(DataResponse::class.java)

                //TODO Create a data class and custom deserializer and clean this interactor thingy
                interactor.startSocket().consumeEach {
                    if (it.exception == null) {
                        Timber.i("raw data %s", it.text)
                        val jsonObject = JSONObject(it.text.toString())
                        //filter response by "data" refactor as a util
                        println("onMassage : " + jsonObject)
                        if (jsonObject.has("data")) {
                            val dataResponse = jsonAdapter.fromJson(it.text.toString())
                            val dataMap = mutableMapOf<String, Content>()
                            fun <T> MutableLiveData<T>.notifyObserver() {
                                this.value = this.value
                            }
                            //Make Dictionary.
                            if (dataResponse != null) {
                                println("onMassage : LEVEL ONE BABY")

                                for (i in dataResponse.data[0].content.indices) {
                                    dataMap[dataResponse.data[0].content[i].key] =
                                        dataResponse.data[0].content[i]
                                }
                                if (webSocketLiveData.value.isNullOrEmpty()) {
                                    //websockets only updates symbols changed, post value would replace all 3 symbols with the new data.
                                    webSocketLiveData.postValue(dataMap)
                                } else {
                                    //we use putALl to only update the future symbol that changed and notifyObserver manually (postValue does it auto).
                                    webSocketLiveData.value!!.putAll(dataMap)
                                    webSocketLiveData.notifyObserver()
                                }
                            }
                        } else if (jsonObject.has("snapshot")) {
                            println("onMassage : YESSSSSSSSSSS")
                        }
                        if (jsonObject.has("response")) {
                            val data = jsonObject.getJSONArray("response")
                            val content = data.getJSONObject(0)
                            if (content.getString("command") == "LOGIN") {
                                Timber.i("Login Command Successful")
                                //start data subscriptions
                               // sendFuturesPayload()
                                sendFuturesHistorical()
                            }
                        }
                    } else {
                        println("onMassage : ERROR YESSSSSSSSSSS")

                        onSocketError(it.exception)
                    }
                }
            } catch (ex: java.lang.Exception) {
                onSocketError(ex)
            }
        }
    }

    private fun onSocketError(ex: Throwable) {
        println("Error occurred : ${ex.message}")
    }

    @ExperimentalCoroutinesApi
    override fun onCleared() {
        interactor.stopSocket()
        super.onCleared()
    }


}


