package com.example.apistock.di

import com.example.apistock.data.api.API_KEY
import com.example.apistock.data.api.StockMarketService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.*

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .baseUrl("https://api.tdameritrade.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }


    @Provides
    fun providesOkHttpInterceptor(): Interceptor{
        return Interceptor { chain ->
            val url = chain.request().url().newBuilder().addQueryParameter("apikey", API_KEY).build()
            Timber.i("%s%s", (Calendar.getInstance().time.toString() + " "), url)
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            chain.proceed(request)
        }
    }

    @Provides
    fun providesOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideMarketApiService(retrofit: Retrofit): StockMarketService {
        return retrofit.create(StockMarketService::class.java)
    }

}