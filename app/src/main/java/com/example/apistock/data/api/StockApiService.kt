package com.example.apistock.data.api


import com.example.apistock.data.entities.*
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

//https://api.tdameritrade.com/v1/marketdata/$SPX.X/movers?apikey=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N&direction=up&change=percent

//v1/marketdata/quotes?apikey=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N&symbol=amd

///1/marketdata/AMD/pricehistory?apikey=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N&periodType=month&period=1&frequencyType=daily

interface StockMarketService {
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

    //https://api.tdameritrade.com/v1/instruments?apikey=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N&symbol=amd.*&projection=symbol-regex

    @GET("/v1/instruments")
    suspend fun fetchSearchSymbolsAsync(
        @Query("symbol") Symbol: String?,
        @Query("projection") Projection: String?
    ): Response<MutableMap<String, SymbolSearch>>


}











