package com.example.composetdaapp.data.entities.watchlist.patch


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PatchWatchlist(
    @Json(name = "name")
    val name: String,
    @Json(name = "watchlistId")
    val watchlistId: String,
    @Json(name = "watchlistItems")
    val watchlistItems: List<WatchlistItems>
)