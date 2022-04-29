/*package com.example.composetdaapp.ui.views.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composetdaapp.utils.MyPreference
import com.example.composetdaapp.data.api.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: MainRepository,
    private val myPreference: MyPreference
) : ViewModel() {

    //create the job, which implements coroutines context.
    var job = Job()

    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    val tokenLiveData = MutableLiveData<String>()


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
            println("Viewmodel tehe: " + tokenDetails.data)
            if (tokenDetails.data?.accessToken != null) {
                myPreference.setAccessToken(tokenDetails.data.accessToken)
                tokenDetails.data.let { myPreference.setRefreshToken(it.refreshToken!!) }
                println("shared pref: "+myPreference.getAccessToken())
                println("HEREE Access Token: " + tokenDetails.data.accessToken)

            }
        }
    }


}
*/
