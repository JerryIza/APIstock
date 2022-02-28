package com.example.composetdaapp.data.entities.watchlist


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Watchlist(
    @Json(name = "accountId")
    val accountId: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "watchlistId")
    val watchlistId: String,
    @Json(name = "watchlistItems")
    val watchlistItems: List<WatchlistItems>
)