package com.example.composetdaapp.data.entities.watchlist


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Instrument(
    @Json(name = "assetType")
    val assetType: String,
    @Json(name = "symbol")
    val symbol: String
)