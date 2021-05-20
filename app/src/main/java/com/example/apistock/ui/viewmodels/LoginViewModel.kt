package com.example.apistock.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apistock.data.api.MainRepository
import com.example.apistock.utils.MyPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val myPreference: MyPreference
) : ViewModel() {

    //create the job, which implements coroutines context.
    var job = Job()

    //create the coroutine context with the job and the dispatcher(identifies the Thread that will be used)
    private val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    val tokenLiveData = MutableLiveData<String>()


    /*private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult
*/
    /*fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }*/

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
            myPreference.setAccessToken(tokenDetails.data!!.accessToken)
            myPreference.setRefreshToken(tokenDetails.data.refreshToken)
            println(tokenDetails.data.refreshToken)
        }
    }


}