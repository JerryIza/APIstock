package com.example.composetdaapp.data.entities.websocket.login

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Parameters(
    @Json(name = "credential")
    val credentials: String,
    @Json(name = "token")
    val token: String,
    @Json(name = "version")
    val version: String = "1.0"


)
