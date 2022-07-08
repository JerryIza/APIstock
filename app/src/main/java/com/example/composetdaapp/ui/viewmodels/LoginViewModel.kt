package com.example.composetdaapp.ui.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composetdaapp.data.api.MainRepository
import com.example.composetdaapp.data.entities.user.UserPrincipals
import com.example.composetdaapp.data.entities.websocket.login.Credentials
import com.example.composetdaapp.data.entities.websocket.login.LoginRequest
import com.example.composetdaapp.data.entities.websocket.login.Parameters
import com.example.composetdaapp.utils.MyPreference
import com.example.composetdaapp.utils.Resource
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.net.URLEncoder.encode
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: MainRepository,
    private val myPreference: MyPreference,
    private val moshi: Moshi
) : ViewModel() {
    //create the job, which implements coroutines context.
    private var job = Job()

    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    val tokenLiveData = MutableLiveData<String?>()

    var userPrincipalsLiveData = MutableLiveData<UserPrincipals>()

    fun checkRefreshToken() = myPreference.getRefreshToken()

    fun refreshTokenAccess() {
        scope.launch {
            myPreference.setAccessToken("")
            val accessToken = repository.postRefreshToken(
                refreshToken = myPreference.getRefreshToken(),
                accessType = "",
                code = ""
            )

            when (accessToken.status) {
                Resource.Status.SUCCESS -> {
                    tokenLiveData.postValue(accessToken.toString())
                    if (!accessToken.data?.accessToken.isNullOrEmpty()) {
                        myPreference.setAccessToken(accessToken.data?.accessToken!!)

                    }
                }
                Resource.Status.ERROR -> {
                    Timber.e("Error getting refresh Token")
                }
                else -> {//TODO}
                }

            }
        }
    }

    fun clearTokenAccess() {
        myPreference.clearStoredTag()
    }

    fun postTokenAccess(code: String) {
        scope.launch {
            val tokenDetails =
                repository.postToken(
                    grantType = "authorization_code",
                    refreshToken = "",
                    accessType = "offline",
                    code
                )
            tokenLiveData.postValue(tokenDetails.toString())
            Timber.v("Viewmodel Token: %s", tokenDetails.data)
            if (tokenDetails.data?.accessToken != null) {
                myPreference.setAccessToken(tokenDetails.data.accessToken)
                tokenDetails.data.let { myPreference.setRefreshToken(it.refreshToken!!) }
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun tempUserPrincipals() {
        scope.launch {
            val userPrincipalsDetail = repository.getUserPrincipals()
            userPrincipalsLiveData.postValue(userPrincipalsDetail.data!!)
            val tokenTimestamp = userPrincipalsDetail.data.streamerInfo.tokenTimestamp
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS")
            val date: Date = sdf.parse(tokenTimestamp)
            val tokenTimestampAsMs: Long = date.toInstant().toEpochMilli()
            val tokenTimestampAsMsOffset: Long = (tokenTimestampAsMs - 18000000)

            Timber.i("Milli with offset: %s", tokenTimestampAsMsOffset)

            //encoder producing unwanted values with adapter, used replace()
            val credential = Credentials(
                userid = userPrincipalsDetail.data.accounts[0].accountId,
                token = userPrincipalsDetail.data.streamerInfo.token,
                company = userPrincipalsDetail.data.accounts[0].company,
                segment = userPrincipalsDetail.data.accounts[0].segment,
                cddomain = userPrincipalsDetail.data.accounts[0].accountCdDomainId,
                usergroup = userPrincipalsDetail.data.streamerInfo.userGroup,
                accesslevel = userPrincipalsDetail.data.streamerInfo.accessLevel,
                timestamp = tokenTimestampAsMsOffset,
                appid = userPrincipalsDetail.data.streamerInfo.appId,
                acl = userPrincipalsDetail.data.streamerInfo.acl
            ).toString()
                .replace("Credentials(", "")
                .replace(",", "&")
                .replace(" ", "")
                .replace(")", "")

            val loginRequests = LoginRequest(
                account = userPrincipalsDetail.data.accounts[0].accountId,
                source = userPrincipalsDetail.data.streamerInfo.appId,
                parameters = Parameters(
                    credentials = encode(credential, "UTF-8"),
                    token = userPrincipalsDetail.data.streamerInfo.token
                )
            )
            val jsonAdapterRequest = moshi.adapter(LoginRequest::class.java)
            val json: String = jsonAdapterRequest.toJson(loginRequests)

            myPreference.setAccountNumber(userPrincipalsDetail.data.primaryAccountId)
            myPreference.setDevUserId(userPrincipalsDetail.data.streamerInfo.appId)
            myPreference.setSocketCredentials(json)
        }
    }


}