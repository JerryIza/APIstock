package com.example.apistock.data.entities

import android.content.ClipData.Item


//@JsonClass(generateAdapter = true)
data class MarketMovers(
    val change: Double,
    val description: String,
    val direction: String,
    val last: Double,
    val symbol: String,
    val totalVolume: Int
)

