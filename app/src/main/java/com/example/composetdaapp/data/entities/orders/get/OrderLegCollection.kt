package com.example.composetdaapp.data.entities.orders.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderLegCollection(
    @Json(name = "instruction")
    val instruction: String,
    @Json(name = "instrument")
    val instrument: Instrument,
    @Json(name = "legId")
    val legId: Int,
    @Json(name = "orderLegType")
    val orderLegType: String,
    @Json(name = "positionEffect")
    val positionEffect: String,
    @Json(name = "quantity")
    val quantity: Int
)