package com.example.composetdaapp.data.entities.orders.place

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Instrument(
    val assetType: String,
    var symbol: String? = null
)