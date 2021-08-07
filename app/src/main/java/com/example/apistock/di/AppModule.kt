package com.example.apistock.di

import com.example.apistock.data.api.API_KEY
import com.example.apistock.data.api.RefreshTokenAuthenticator
import com.example.apistock.data.api.StockMarketService
import com.example.apistock.utils.MyPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
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
            val url = chain.request().url().newBuilder().addQueryParameter("apikey", API_KEY).build()
            val request = chain.request().newBuilder().url(url).build()
            println(Calendar.getInstance().time)
            if (myPreference.getAccessToken().isBlank()) {
                println("Before Authentication" + myPreference.getAccessToken())
                chain.proceed(request)
            } else {
                println("After Authentication: " + myPreference.getAccessToken())
                println("After Authentication: " + myPreference.getRefreshToken())
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

    @Provides
    fun tokenRefreshAuthenticator(): Authenticator {
        return Authenticator { _, response ->
            when {
                response.isSuccessful -> null
                else -> response.request()  //.createSignedRequest()
            }
            response.request()
        }
    }

    @Provides
    fun provideMarketApiService(retrofit: Retrofit): StockMarketService {
        return retrofit.create(StockMarketService::class.java)
    }
    @Singleton
    @Provides
    fun providesTokenRefreshAuthenticator(
        myPreference: MyPreference
    ): RefreshTokenAuthenticator {
        return RefreshTokenAuthenticator(myPreference)
    }
}

