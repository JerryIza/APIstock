package com.example.composetdaapp.data.entities.websocket.request

import com.example.composetdaapp.data.entities.websocket.response.Content
import com.example.composetdaapp.data.entities.websocket.response.Data
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataRequest(
    val request: List<Request>,
    /*val `notify`: List<String>,
    val `response`: List<String>,*/
)
