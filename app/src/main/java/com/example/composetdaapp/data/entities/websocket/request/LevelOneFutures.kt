package com.example.composetdaapp.data.entities.websocket.request


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
//TODO work in progress
@JsonClass(generateAdapter = true)
data class LevelOneFutures(
    @Json(name = "account")
    val account: String = "ACCOUNT",
    @Json(name = "command")
    val command: String = "SUBS",
    @Json(name = "parameters")
    val parameters: Parameters,
    @Json(name = "requestid")
    val requestid: String = "1",
    @Json(name = "service")
    val service: String = "LEVELONE_FUTURES",
    @Json(name = "source")
    val source: String = "USERID"
)