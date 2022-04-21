package com.example.composetdaapp.data.entities.websocket.response

import com.example.composetdaapp.data.entities.websocket.response.Content
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val command: String,
    val content: List<Content>,
    val service: String,
    val timestamp: Long
)