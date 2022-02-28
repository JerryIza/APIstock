package com.example.composetdaapp.di

import com.example.composetdaapp.data.websocket.WebServicesProvider
import com.example.composetdaapp.utils.MyPreference
import com.example.composetdaapp.data.api.API_KEY
import com.example.composetdaapp.data.api.RefreshTokenAuthenticator
import com.example.composetdaapp.data.api.StockApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .baseUrl("https://api.tdameritrade.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun providesOkHttpInterceptor(myPreference: MyPreference): Interceptor {
        return Interceptor { chain ->
            val url = chain.request().url.newBuilder().addQueryParameter("apikey", API_KEY).build()
            val request = chain.request().newBuilder().url(url).build()
            println("HTTP Request: "+Calendar.getInstance().time)
            println("HTTP Request: "+url)

            if (myPreference.getAccessToken().isBlank()) {
                println("Before Authentication" + myPreference.getAccessToken())
                chain.proceed(request)
            } else {
                println("After Authentication Access Token: " + myPreference.getAccessToken())
                println("After Authentication Refresh Token: " + myPreference.getRefreshToken())
                chain.proceed(request.providesBearerToken(myPreference.getAccessToken()))
            }
        }
    }

    @Provides
    fun providesOkHttpClient(
        interceptor: Interceptor, authenticator: RefreshTokenAuthenticator
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .authenticator(authenticator)
            .build()
    }

    @Provides
    fun Request.providesBearerToken(accessToken: String): Request {
        return newBuilder()
            .addHeader("Authorization", "Bearer $accessToken")
            .build()
    }

    //websocket
    @Provides
    fun provideWebServiceProvider(myPreference: MyPreference): WebServicesProvider {
        return WebServicesProvider(myPreference)
    }

    //test socket
    @Provides
    fun provideMarketApiService(retrofit: Retrofit): StockApiService {
        return retrofit.create(StockApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesTokenRefreshAuthenticator(
        myPreference: MyPreference
    ): RefreshTokenAuthenticator {
        return RefreshTokenAuthenticator(myPreference)
    }
}

