package com.example.composetdaapp.data.entities.websocket

import com.example.composetdaapp.data.entities.websocket.response.Data
import com.example.composetdaapp.data.entities.websocket.response.Notify
import com.example.composetdaapp.data.entities.websocket.response.Response
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResponse(
    val `data`: List<Data>?,
    @Json(name = "notify")
    val notify: List<Notify>?,
    val response: List<Response?>?,
    val snapshot: String? = null,
    )