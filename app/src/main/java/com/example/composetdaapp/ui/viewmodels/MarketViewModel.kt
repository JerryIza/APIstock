package com.example.composetdaapp.ui.viewmodels

import androidx.lifecycle.*
import com.example.composetdaapp.data.entities.quotes.SymbolSearch
import com.example.composetdaapp.data.entities.account.Accounts
import com.example.composetdaapp.data.entities.account.Positions
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.data.entities.watchlist.Watchlist
import com.example.composetdaapp.data.entities.websocket.Content
import com.example.composetdaapp.data.entities.websocket.DataResponse
import com.example.composetdaapp.indicators.UpperIndicators
import com.example.composetdaapp.utils.MyPreference
import com.example.composetdaapp.utils.Resource
import com.example.composetdaapp.data.api.MainRepository
import com.example.composetdaapp.data.entities.orders.get.GetOrderItem
import com.example.composetdaapp.utils.SocketInteractor
import com.github.mikephil.charting.data.Entry
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.json.JSONObject
import javax.annotation.concurrent.Immutable
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext



@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
@HiltViewModel
class MarketViewModel @Inject constructor(
    private val interactor: SocketInteractor,
    private val repository: MainRepository,
    private val myPreference: MyPreference
) :
    ViewModel() {


    /*Start of Jeptpack state*/
    private val _cards = MutableStateFlow(listOf<ExpandableCardModel>())
    val cards: StateFlow<List<ExpandableCardModel>> get() = _cards

    private val _expandedCardIdsList = MutableStateFlow(listOf<Int>())
    val expandedCardIdsList: StateFlow<List<Int>> get() = _expandedCardIdsList

    init {
        getFakeData()
    }

    private fun getFakeData() {
        viewModelScope.launch(Dispatchers.Default) {
            val testList = arrayListOf<ExpandableCardModel>()
            repeat(20) { testList += ExpandableCardModel(id = it, title = "Card $it") }
            _cards.emit(testList)
        }
    }

    fun onCardArrowClicked(cardId: Int) {
        _expandedCardIdsList.value = _expandedCardIdsList.value.toMutableList().also { list ->
            if (list.contains(cardId)) list.remove(cardId) else list.add(cardId)
        }
    }

    @Immutable
    data class ExpandableCardModel(val id: Int, val title: String)
    /* End of Jetpack*/


    //ADD RESOURCE TO ALL VAL/VAR


    //create the job, which implements coroutines context.
    var job = Job()

    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    private val _symbol = MutableLiveData<String>()

    val watchlistLiveData = MutableLiveData<Resource<List<Watchlist>>>()

    val watchlistQuotes = MutableLiveData<Resource<MutableMap<String?, SymbolDetails>>>()

    var accountDetailsLiveData = MutableLiveData<Resource<Accounts>>()

    var posQuotesLiveData = MutableLiveData<List<SymbolDetails>>()

    var posMediatorLiveData = MediatorLiveData<MutableMap<Positions, SymbolDetails>>()

    val watchlistNames: MutableList<String> = ArrayList()

    private val symbolLiveData = MutableLiveData<Resource<MutableMap<String?, SymbolDetails>>>()

    val ordersLiveData = MutableLiveData<Resource<List<GetOrderItem>>>()

    var upperIndicators = UpperIndicators()

    var indicatorLiveData: MutableLiveData<List<Entry>> = MutableLiveData()

    val webSocketLiveData = MutableLiveData<MutableMap<String, Content>>()


    /*private suspend fun getIndicatorData(historicalData: Resource<HistoricalData>): List<Entry> {
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
   }*/

    /*private suspend fun getIndicatorData(historicalData: Resource<HistoricalData>): List<Entry> {
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
 }*/


    fun accountPosDetails() {
        scope.launch {
            //unnessesary call
            val accDetails = getAccountDetails()
            accountDetailsLiveData.postValue(accDetails)
            val accPositions = (accDetails.data?.securitiesAccount?.positions)
            val stringBuilder = StringBuilder()
            if (!accPositions.isNullOrEmpty()) {
                accPositions.removeIf { it.instrument.symbol == "MMDA1" }

                for (i in accPositions.indices) {
                    stringBuilder.append(accPositions[i].instrument.symbol + ",")
                }
                println("account quotes 1: " + accPositions)
            }
            //HTTP request for Positions Quotes
            println("account quotes 2: " + stringBuilder)
            val posQuotes = repository.getSymbolDetails(stringBuilder.toString())
            if (!posQuotes.data.isNullOrEmpty()) {
                posQuotesLiveData.postValue(posQuotes.data.values.toMutableList())
                println("account quotes 2.5: " + posQuotesLiveData.value)
            }

            try {
                //observe pos http update
                posMediatorLiveData.addSource(accountDetailsLiveData) { posValues ->
                    if (!posQuotesLiveData.value.isNullOrEmpty()) {
                        when (posValues.status) {
                            Resource.Status.SUCCESS -> {
                                val accPosUpdate = mutableMapOf<Positions, SymbolDetails>()
                                if (!accPositions.isNullOrEmpty()) {
                                    for (i in accPositions.indices) {
                                        accPosUpdate[posValues.data!!.securitiesAccount.positions[i]] =
                                            posQuotesLiveData.value!![i]
                                    }
                                }
                                posMediatorLiveData.postValue(accPosUpdate)
                                println("account quotes 3 " + posMediatorLiveData.value)
                            }
                            Resource.Status.ERROR -> println(posValues.message)
                            Resource.Status.LOADING -> println("Loading")
                        }
                    }
                }
                //observer quote http update
                posMediatorLiveData.addSource(posQuotesLiveData) { quoteValues ->
                    val accQuotesUpdate = mutableMapOf<Positions, SymbolDetails>()
                    for (i in accPositions!!.indices) {
                        accQuotesUpdate[accountDetailsLiveData.value!!.data!!.securitiesAccount.positions[i]] =
                            quoteValues[i]
                    }
                    posMediatorLiveData.postValue(accQuotesUpdate)
                    println("account quotes 4 " + posMediatorLiveData.value)

                }
            } catch (e: IllegalArgumentException) {
                posMediatorLiveData.removeSource(symbolLiveData)
                posMediatorLiveData.removeSource(posQuotesLiveData)
            }
        }
    }


    suspend fun getAccountDetails() = repository.getAccountDetails()


    fun getAllWatchlist() {
        scope.launch {
            val allWatchlist = repository.getAllWatchlist()
            if (!allWatchlist.data.isNullOrEmpty()) {
                watchlistNames.clear()
                for (i in allWatchlist.data.indices) {
                    watchlistNames.add(i, allWatchlist.data[i].name)
                    println("delete " + allWatchlist.data[i])

                }
            }
            watchlistLiveData.postValue(allWatchlist)
        }
    }

    fun patchWatchlist(watchlistId: String, symbolUpdate: String) {
        scope.launch {
            val patchedWatchlists =
                repository.patchWatchlist("149235993", watchlistId, symbolUpdate)
        }
    }

    fun getMultiSymbolDetails(string: String) {
        scope.launch {
            val multiSymbolDetails = repository.getSymbolDetails(string)
            println("getMultiSymbolDetails: $multiSymbolDetails")
            watchlistQuotes.postValue(multiSymbolDetails)
        }
    }

    fun getOrders() {
        scope.launch {
            val orders = repository.getOrders()
            ordersLiveData.postValue(orders)
        }

    }


    fun start(symbol: String) {
        _symbol.value = symbol
        //Timber.tag(("Start Symbol = " + _symbol.value))
    }


    val futuresPayload = "{\n" +
            "            \"service\": \"LEVELONE_FUTURES\",\n" +
            "            \"requestid\": \"2\",\n" +
            "            \"command\": \"SUBS\",\n" +
            "            \"account\": \"149235993\",\n" +
            "            \"source\": \"gerardoiza94\",\n" +
            "            \"parameters\": {\n" +
            "                \"keys\": \"/ES,/NQ,/YM\",\n" +
            "                \"fields\": \"0,3,19,20,34\"\n" +
            "            }\n" +
            "        }"

    val optionsPayload = "         {\n" +
            "            \"service\": \"CHART_EQUITY\",\n" +
            "            \"requestid\": \"2\",\n" +
            "            \"command\": \"SUBS\",\n" +
            "            \"account\": \"149235993\",\n" +
            "            \"source\": \"gerardoiza94\",\n" +
            "            \"parameters\": {\n" +
            "                \"keys\": \"NVDA\",\n" +
            "                \"fields\": \"0,1,2,3,4\"\n" +
            "            }\n" +
            "        }"


    //private fun sendFuturesPayload() = interactor.sendSocketRequest(futuresPayload)

    private fun sendFuturesPayload() = interactor.sendSocketRequest(futuresPayload)


    val moshi = Moshi.Builder().build()

    //WebSocket Please Move somewhere else

    @ExperimentalCoroutinesApi
    fun subscribeToSocketEvents() {
        viewModelScope.launch {
            try {
                //we subscribe to many different event
                interactor.startSocket().consumeEach {
                    if (it.exception == null) {
                        val jsonObject = JSONObject(it.text.toString())
                        //filter response by "data" refactor as a util
                        if (jsonObject.has("data")) {
                            val jsonAdapter = moshi.adapter(DataResponse::class.java)
                            val dataResponse = jsonAdapter.fromJson(it.text.toString())
                            val dataMap = mutableMapOf<String, Content>()

                            println("FUTURES RESPONSE: " + dataResponse)
                            fun <T> MutableLiveData<T>.notifyObserver() {
                                this.value = this.value
                            }
                            //Make Dictionary.
                            if (dataResponse != null) {
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
                        }
                        if (jsonObject.has("response")) {
                            val data = jsonObject.getJSONArray("response")
                            val content = data.getJSONObject(0)
                            if (content.getString("command") == "LOGIN") {

                                println("Login Command Successful")
                                //start data subscriptions
                                sendFuturesPayload()
                            }
                        }
                    } else {
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






