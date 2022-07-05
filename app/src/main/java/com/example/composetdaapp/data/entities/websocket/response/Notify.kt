package com.example.composetdaapp.data.entities.websocket.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Notify(
    @Json(name = "heartbeat")
    val heartbeat: String? = null
) 