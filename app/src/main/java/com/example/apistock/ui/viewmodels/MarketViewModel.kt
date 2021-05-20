package com.example.apistock.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apistock.data.api.MainRepository
import com.example.apistock.data.entities.SymbolSearch
import com.example.apistock.data.entities.account.Accounts
import com.example.apistock.data.entities.account.Positions
import com.example.apistock.data.entities.quotes.HistoricalData
import com.example.apistock.data.entities.quotes.SymbolDetails
import com.example.apistock.data.entities.user.UserPrincipals
import com.example.apistock.data.entities.watchlist.Watchlist
import com.example.apistock.indicators.UpperIndicators
import com.example.apistock.utils.MyPreference
import com.example.apistock.utils.Resource
import com.example.apistock.utils.ToCandleEntries
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
class MarketViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val myPreference: MyPreference
) :
    ViewModel() {

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

    var posLiveData = MediatorLiveData<ArrayList<Pair<Positions, SymbolDetails>>>()

    val watchlistNames: MutableList<String> = ArrayList()

    val symbolLiveData = MutableLiveData<Resource<MutableMap<String?, SymbolDetails>>>()

    var upperIndicators = UpperIndicators()

    val chartLiveData = MediatorLiveData<MutableList<CandleEntry>>()

    var candleEntries: MutableList<CandleEntry> = ArrayList()

    var indicatorEntries: List<Entry> = ArrayList()

    var indicatorLiveData: MutableLiveData<List<Entry>> = MutableLiveData()

    var searchResultsLiveData: MutableLiveData<MutableMap<String, SymbolSearch>> = MutableLiveData()

    var tempCredentialsLiveData = MutableLiveData<Resource<UserPrincipals>>()

    val tokenLiveData = MutableLiveData<String>()


    fun refreshTokenAccess() {
        scope.launch {
            val tokenDetails =
                repository.postToken(
                    grantType = "refresh_token",
                    refreshToken = myPreference.getRefreshToken(),
                    accessType = "",
                    code = ""

                )
            tokenLiveData.postValue(tokenDetails.toString())
            myPreference.setAccessToken(tokenDetails.data!!.accessToken)
            println(tokenDetails.data.refreshToken)
        }
    }


    fun accountPosDetails() {
        getAccountDetails()
        //get symbols for account positions.
        val accPositions = (accountDetailsLiveData.value?.data?.securitiesAccount?.positions)
        val stringBuilder = StringBuilder()
        if (!accPositions.isNullOrEmpty()) {
            for (i in accPositions.indices - 1) {
                stringBuilder.append(accPositions[i].instrument.symbol)
            }
        }
        //get quotes for account symbols.
        scope.launch {
            val posQuotes = repository.getSymbolDetails(stringBuilder.toString())
            if (!posQuotes.data.isNullOrEmpty()) {
                posQuotesLiveData.postValue(posQuotes.data.values.toMutableList())
            }
        }
        try {
            posLiveData.addSource(accountDetailsLiveData) { posValues ->
                if (!posQuotesLiveData.value.isNullOrEmpty()) {
                    when (posValues.status) {
                        Resource.Status.SUCCESS -> {
                            posLiveData.postValue(
                                arrayListOf(
                                    Pair(
                                        posValues.data!!.securitiesAccount.positions[0],
                                        posQuotesLiveData.value!![0]
                                    )
                                )
                            )
                        }
                        Resource.Status.ERROR -> println(posValues.message)
                        Resource.Status.LOADING -> println("TEHEHE")
                    }
                }
            }
            posLiveData.addSource(posQuotesLiveData) { quoteValues ->
                posLiveData.postValue(
                    arrayListOf(
                        Pair(
                            accountDetailsLiveData.value!!.data!!.securitiesAccount.positions[0],
                            quoteValues[0]
                        )
                    )
                )
            }
        } catch (e: IllegalArgumentException) {
            posLiveData.removeSource(symbolLiveData)
            posLiveData.removeSource(posQuotesLiveData)
        }


    }


    fun getAccountDetails() {
        scope.launch {
            val accountDetails = repository.getAccountDetails()
            accountDetailsLiveData.postValue(accountDetails)
        }
    }


    fun getAllWatchlist() {
        scope.launch {
            val allWatchlist = repository.getAllWatchlist()
            if (!allWatchlist.data.isNullOrEmpty()) {
                watchlistNames.clear()
                for (i in allWatchlist.data.indices) {
                    watchlistNames.add(i, allWatchlist.data[i].name)
                }
            }
            watchlistLiveData.postValue(allWatchlist)
        }
    }

    fun getMultiSymbolDetails(string: String) {
        scope.launch {
            val multiSymbolDetails = repository.getSymbolDetails(string)
            println(multiSymbolDetails)
            watchlistQuotes.postValue(multiSymbolDetails)
        }
    }

    fun getSymbolDetails() {
        scope.launch {
            val symbolDetails = repository.getSymbolDetails(_symbol.value.toString())
            symbolLiveData.postValue(symbolDetails)
        }
    }


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
                        candleEntries = ToCandleEntries.toCandleEntry(historicalData)

                    }

                    /*if (candleEntries.isEmpty()) {
                    }*/
                    when (historicalData.status) {
                        Resource.Status.SUCCESS -> {

                            val historicalDataSize = (historicalData.data!!.candles.lastIndex + 1)
                            //remove and update today's candle.
                            chartLiveData.value = ToCandleEntries.lastCandleUpdate(
                                candleEntries,
                                it.data?.values!!.last(),
                                historicalDataSize
                            )
                        }
                        Resource.Status.ERROR -> println(historicalData.message)
                        Resource.Status.LOADING -> println("TEHEHE")
                    }
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
            searchResultsLiveData.postValue(searchResults.data!!)

        }

    }

    fun get52WeekHighLow(last: Double, low: Double, high: Double) =
        (((last - low) / (high - low)) * 100).toInt()

    fun tempUserPrincipals() {
        scope.launch {
            val userPrincipalsDetail = repository.getUserPrincipals()
            tempCredentialsLiveData.postValue(userPrincipalsDetail)
        }
    }


}
