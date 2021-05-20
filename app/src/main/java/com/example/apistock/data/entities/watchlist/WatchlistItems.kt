package com.example.apistock.data.entities.watchlist


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WatchlistItems(
    @Json(name = "averagePrice")
    val averagePrice: Int,
    @Json(name = "commission")
    val commission: Int,
    @Json(name = "instrument")
    val instrument: Instrument,
    @Json(name = "quantity")
    val quantity: Int,
    @Json(name = "sequenceId")
    val sequenceId: Int
)