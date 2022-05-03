package com.example.composetdaapp.data.entities.websocket.login

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "service")
    val service: String = "ADMIN",
    @Json(name = "requestid")
    val requestId: String = "0",
    @Json(name = "command")
    val command: String = "LOGIN",
    @Json(name = "account")
    val account: String,
    @Json(name = "source")
    val source: String,
    @Json(name = "parameters")
    val parameters: Parameters,


    )
