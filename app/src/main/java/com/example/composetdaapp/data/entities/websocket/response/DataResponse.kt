package com.example.composetdaapp.data.entities.websocket.response

import com.example.composetdaapp.data.entities.websocket.response.Data
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResponse(
    val `data`: List<Data>,
    /*val `notify`: List<String>,
    val `response`: List<String>,*/
)