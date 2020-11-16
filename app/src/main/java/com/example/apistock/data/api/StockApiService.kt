package com.example.apistock.data.api


import com.example.apistock.data.entities.MarketMovers
import com.example.apistock.data.entities.SymbolDetails
import com.example.apistock.data.entities.HistoricalData
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*


const val API_KEY = "LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N"

//object that creates our service for making request to API
object StockApiService {
    //network interceptor that will add our key
    private val interceptor = Interceptor { chain ->
        val url = chain.request().url().newBuilder().addQueryParameter("apikey", API_KEY).build()
        println( Calendar.getInstance().time.toString() +" " + url)
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        chain.proceed(request)
    }

    private val apiClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().client(apiClient)
            .baseUrl("https://api.tdameritrade.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val stockApi: MarketMoversService = getRetrofit().create(MarketMoversService::class.java)
}

//https://api.tdameritrade.com/v1/marketdata/$SPX.X/movers?apikey=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N&direction=up&change=percent

//v1/marketdata/quotes?apikey=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N&symbol=amd

///v1/marketdata/AMD/pricehistory?apikey=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N&periodType=month&period=1&frequencyType=daily

interface MarketMoversService {
    @GET("/v1/marketdata/{Stock}/movers")
    suspend fun fetchMoversDetailsAsync(@Path("Stock") Stock: String?): Response<MutableList<MarketMovers>>

    //use Map for dynamic keys
    @GET("/v1/marketdata/quotes")
    suspend fun fetchSymbolDetailsAsync(@Query("symbol") symbol: String?): Response<MutableMap<String?, SymbolDetails>>

    @GET("/v1/marketdata/{Symbol}/pricehistory")
    suspend fun fetchHistoricalDataAsync(
        @Path("Symbol") Symbol: String?,
        @Query("periodType") periodType: String?,
        @Query("period") period: String?,
        @Query("frequencyType") frequencyType: String?
    ): Response<HistoricalData>


}











