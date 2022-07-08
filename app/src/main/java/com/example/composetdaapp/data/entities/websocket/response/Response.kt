package com.example.composetdaapp.data.entities.websocket.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
@Json(name = "command")
val command: String,
@Json(name = "content")
val content: Rcontent,
@Json(name = "requestid")
val requestid: String,
@Json(name = "service")
val service: String,
@Json(name = "timestamp")
val timestamp: Long
)