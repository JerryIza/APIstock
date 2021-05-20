package com.example.apistock.data.api

import com.example.apistock.data.entities.token.TokenAccess
import com.example.apistock.utils.MyPreference
import kotlinx.coroutines.runBlocking
import okhttp3.*
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import javax.inject.Inject


class RefreshTokenAuthenticator @Inject constructor(
    private val myPreference: MyPreference
) : Authenticator {

    var lazyService: Lazy<StockMarketService>? = null

    @Inject
    fun getLazy(foo: Lazy<StockMarketService>?) {
        this.lazyService = foo
    }

    override fun authenticate(route: Route?, originalResponse: Response): Request? {
        if (originalResponse.isUnauthorized()) {

            if (!isEligibleForRefresh(originalResponse)) {
                println("NOT Eligible for refresh.")
                return null
            }

            if (/*isTokenRenewable() &&*/ retryCount(originalResponse) < 100) {
                println("TRY RESPONSE: " + retryCount(originalResponse))
                getLazy(lazyService)

                val authData = lazyService?.let { renewToken(it) }

                    println("authData: "+ authData)
                if (authData != null) {
                    println("authodata is not null = $authData")
                    if (canRetryRequest(originalResponse, authData)) {
                        myPreference.setAccessToken(authData.accessToken)
                        return retryRequest(
                            originalResponse,
                            authData.accessToken,
                            retryCount(originalResponse) + 1
                        )
                    }
                }
            }
        }
        println("worked? "+ myPreference.getAccessToken())
        return null
    }

    private fun Response.isUnauthorized() = this.code() == HTTP_UNAUTHORIZED

    private fun canRetryRequest(originalResponse: Response, currentAuthData: TokenAccess?) =
        originalResponse.request().headers("Authorization").isNotEmpty()
                && originalResponse.request()
            .headers("Authorization")[0] != currentAuthData!!.accessToken

    //private fun isTokenRenewable() = otacRepository.getData().canRefresh() ?: false

    private fun isEligibleForRefresh(originalResponse: Response): Boolean {
        return originalResponse.request().header("Authorization") != true.toString()
    }

    private fun renewToken(webApi: Lazy<StockMarketService>) =
        runBlocking {
            val result = webApi.value.fetchTokenAsync(
                grant_Type = "refresh_token",
                refresh_Token = myPreference.getRefreshToken(),
                access_Type = "",
                Code = "",
                "LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N@AMER.OAUTHAP",
                "http://localhost")
                    result.body()
                }


    private fun retryRequest(
        originalResponse: Response,
        accessToken: String,
        retryCount: Int) = originalResponse.request()
        .newBuilder()
        .removeHeader("Authorization")
        .addHeader("Authorization", "Bearer $accessToken")
        .build()


    private fun retryCount(response: Response?): Int {
        return response?.request()?.header(HEADER_RETRY_COUNT)?.toInt() ?: 0
    }

    companion object {
        const val HEADER_RETRY_COUNT = "xInternalRetryCount"
    }


}