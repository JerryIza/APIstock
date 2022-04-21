package com.example.composetdaapp.data.api

import com.example.composetdaapp.utils.Resource
import retrofit2.Response

//abstract means we must have at least one method that is overwritten, this will be overwritten in our repo
abstract class BaseDataSource {

    protected suspend fun <T : Any> getResults(call: suspend () -> Response<T>): Resource<T> {
        try {

            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                println("BODY : $body")
                if (body != null) return Resource.success(body)

            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }
    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message")
    }
}