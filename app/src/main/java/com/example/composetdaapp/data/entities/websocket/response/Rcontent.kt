package com.example.composetdaapp.data.entities.websocket.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rcontent(
    val code: String? = null,
    val msg: String? = null
)