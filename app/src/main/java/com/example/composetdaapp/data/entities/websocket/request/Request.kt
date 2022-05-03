package com.example.composetdaapp.data.entities.websocket.request


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
//TODO work in progress, use enum in service key?
@JsonClass(generateAdapter = true)
data class Request(
    @Json(name = "account")
    val account: String,
    @Json(name = "command")
    val command: String = "SUBS",
    @Json(name = "parameters")
    val futuresParam: FuturesParam,
    @Json(name = "requestid")
    val requestId: String = "1",
    @Json(name = "service")
    val service: String,
    @Json(name = "source")
    val source: String
)





