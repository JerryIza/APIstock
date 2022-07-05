package com.example.composetdaapp.data.websocket

import com.example.composetdaapp.utils.Resource
import retrofit2.Response
import timber.log.Timber

abstract class SocketDataSource {

    protected suspend fun <T : Any> getResults(call: suspend () -> Response<T>): Resource<T> {
        try {

            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                Timber.i("Response Body: $response")
                if (body != null) return Resource.success(body)

            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }
    private fun <T> error(message: String): Resource<T> {
        return Resource.error(message)
    }
}