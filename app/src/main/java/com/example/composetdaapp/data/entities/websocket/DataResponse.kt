package com.example.composetdaapp.data.entities.websocket

import com.example.composetdaapp.data.entities.websocket.Data
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResponse(
    val `data`: List<Data>
)