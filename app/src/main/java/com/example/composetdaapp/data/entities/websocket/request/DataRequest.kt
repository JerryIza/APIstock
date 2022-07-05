package com.example.composetdaapp.data.entities.websocket.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataRequest(
    val request: List<Request>,

)
