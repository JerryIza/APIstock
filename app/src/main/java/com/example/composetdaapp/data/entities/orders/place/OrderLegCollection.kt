package com.example.composetdaapp.data.entities.orders.place

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderLegCollection(
    var instruction: String? = null,
    val instrument: Instrument,
    var quantity: Int? = null
)