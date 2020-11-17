package com.example.apistock.data.entities


import com.squareup.moshi.Json

data class Candle(
    val close: Double,
    val datetime: Long,
    val high: Double,
    val low: Double,
    val `open`: Double,
    val volume: Int
)