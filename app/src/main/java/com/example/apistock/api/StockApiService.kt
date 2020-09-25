package com.example.apistock.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val API_KEY = "LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N"

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

        val stockApi: StockApiInterface = getRetrofit().create(StockApiInterface::class.java)
    }


        interface StockApiInterface {
            //fetches symbols with query param
            @GET("/v1/instruments/{Stock}")
            suspend fun fetchSymbolDetailsAsync(

                @Path("Stock") Stock: String?
            ): Response<MutableList<SymbolDetails>>

        }
        //https://api.tdameritrade.com/v1/instruments/NVDA?apikey=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N


        //handle network response, success or failure with exception.
        sealed class Output<out T : Any> {
            data class Success<out T : Any>(val output: T) : Output<T>()
            data class Error(val exception: Exception) : Output<Nothing>()

        }






