package com.example.composetdaapp.data.entities.websocket.request


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//TODO Work in progress futures parameters?
@JsonClass(generateAdapter = true)
data class FuturesParam(
    @Json(name = "fields")
    val fields: String = "0,3,19,20,34",
    @Json(name = "keys")
    val keys: String = "/ES,/NQ,/YM"
)