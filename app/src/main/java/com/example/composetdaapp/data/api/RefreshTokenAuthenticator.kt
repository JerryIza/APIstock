package com.example.composetdaapp.data.api

import com.example.composetdaapp.data.entities.token.TokenAccess
import com.example.composetdaapp.utils.MyPreference
import com.example.composetdaapp.utils.Resource
import kotlinx.coroutines.*
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider


class RefreshTokenAuthenticator @Inject constructor(
    private val myPreference: MyPreference,
    private val lazyRepo: Provider<MainRepository>
) : Authenticator {
    private val notLoggedResponseCode = 401
    private val Response.responseCount: Int
        get() = generateSequence(this) { it.priorResponse }.count()



    override fun authenticate(route: Route?, response: Response): Request {





        if (response.code == notLoggedResponseCode && response.responseCount <= 3) {
            //Set token to blank so Interceptor removes header.
            myPreference.setAccessToken("")
            suspend fun getAccessToken(): Resource<TokenAccess> = withContext(Dispatchers.IO) {
                lazyRepo.get().postRefreshToken(
                    refreshToken = myPreference.getRefreshToken(),
                    accessType = "",
                    code = ""
                )
            }

            val refreshResponse = runBlocking { getAccessToken() }
            refreshResponse.data?.accessToken?.let { myPreference.setAccessToken(it) }
            Timber.v("Refresh auth response%s", refreshResponse)

        }
        //header will be added back by interceptor
        return response.request.newBuilder().header("Authorization", "Bearer ${myPreference.getAccessToken()}").build()

    }
}

