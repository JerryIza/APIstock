package com.example.composetdaapp.ui.viewmodels

import android.annotation.SuppressLint
import android.view.View
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composetdaapp.data.api.MainRepository
import com.example.composetdaapp.data.entities.user.UserPrincipals
import com.example.composetdaapp.utils.MyPreference
import com.example.composetdaapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONObject
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: MainRepository,
    private val myPreference: MyPreference
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
            println("POSTED Malone #  " + myPreference.getAccessToken())
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

            Timber.v("Milli with offset: %s", tokenTimestampAsMsOffset)

            /*TODO Create data class instead*/
            val credentials = (
                    "userid" + "=" + userPrincipalsDetail.data.accounts[0].accountId + "&" +
                            "token" + "=" + userPrincipalsDetail.data.streamerInfo.token + "&" +
                            "company" + "=" + userPrincipalsDetail.data.accounts[0].company + "&" +
                            "segment" + "=" + userPrincipalsDetail.data.accounts[0].segment + "&" +
                            "cddomain" + "=" + userPrincipalsDetail.data.accounts[0].accountCdDomainId + "&" +
                            "usergroup" + "=" + userPrincipalsDetail.data.streamerInfo.userGroup + "&" +
                            "accesslevel" + "=" + userPrincipalsDetail.data.streamerInfo.accessLevel + "&" +
                            "authorized" + "=" + "Y" + "&" +
                            "timestamp" + "=" + tokenTimestampAsMsOffset + "&" +
                            "appid" + "=" + userPrincipalsDetail.data.streamerInfo.appId + "&" +
                            "acl" + "=" + userPrincipalsDetail.data.streamerInfo.acl
                    )

            val encodedCredentials = java.net.URLEncoder.encode(credentials, "utf-8")


            val loginRequest = hashMapOf<Any, Any>(
                "service" to "ADMIN",
                "requestid" to "0",
                "command" to "LOGIN",
                "account" to userPrincipalsDetail.data.accounts[0].accountId,
                "source" to userPrincipalsDetail.data.streamerInfo.appId,
                "parameters" to hashMapOf(
                    "credential" to encodedCredentials,
                    "token" to userPrincipalsDetail.data.streamerInfo.token,
                    "version" to "1.0"
                )
            )
            println("onMessage LoginP: " + loginRequest)

            val payload = JSONObject(loginRequest as Map<*, *>?)

            myPreference.setAccountNumber(userPrincipalsDetail.data.primaryAccountId)
            myPreference.setUserId(userPrincipalsDetail.data.userId)
            myPreference.setSocketCredentials(payload.toString())
        }
    }


}