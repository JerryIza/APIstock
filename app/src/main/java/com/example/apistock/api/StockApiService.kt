package com.example.apistock.api


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


const val API_KEY = "LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N"
    //object that creates our service for making request to API
    object StockApiService {
        //network interceptor that will add our key
        private val interceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder().addQueryParameter("apikey", API_KEY).build()
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

    interface MarketMoversService {

        @GET("/v1/marketdata/{Stock}/movers")
        suspend fun fetchSymbolDetailsAsync(@Path("Stock") Stock: String?): Response<MutableList<MarketMovers>>
    }









