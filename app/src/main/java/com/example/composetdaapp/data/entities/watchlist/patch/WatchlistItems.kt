package com.example.composetdaapp.data.entities.watchlist.patch


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WatchlistItems(
    @Json(name = "instrument")
    val instrument: Instrument?,
    @Json(name = "sequenceId")
    val sequenceId: Int
)