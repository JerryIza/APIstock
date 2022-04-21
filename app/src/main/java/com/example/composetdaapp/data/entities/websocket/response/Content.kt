package com.example.composetdaapp.data.entities.websocket.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Content(
    @Json(name = "19")
    val futNetChange: Double? = null,
    @Json(name = "20")
    val futPcChange: Double? = null,
    @Json(name = "3")
    val futLast: Double? = null,
    @Json(name = "34")
    val activeFut: String? = null,
    val assetMainType: String? = null,
    val delayed: Boolean? = null,
    val key: String
)