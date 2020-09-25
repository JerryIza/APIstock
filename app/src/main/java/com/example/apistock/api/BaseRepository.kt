package com.example.apistock.api

import android.util.Log
import okhttp3.Response
import java.io.IOException

//handle the safe API calls

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call : suspend()-> retrofit2.Response<T>, error : String) :  T?{
        val result = stockApiOutput(call, error)
        var output : T? = null
        when(result){
            is Output.Success ->
                output = result.output
            is Output.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }
    private suspend fun<T : Any> stockApiOutput(call: suspend()-> retrofit2.Response<T> , error: String) : Output<T>{
        val response = call.invoke()
        return if (response.isSuccessful)
            Output.Success(response.body()!!)
        else
            Output.Error(IOException("Oops .. Something went wrong due to  $error"))
    }
}