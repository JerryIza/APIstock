package com.example.composetdaapp.data.entities.websocket.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    val command: String,
    val content: Content,
    val service: String,
    val timestamp: Long
)