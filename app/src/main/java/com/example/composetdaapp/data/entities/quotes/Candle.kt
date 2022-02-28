package com.example.composetdaapp.data.entities.quotes


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Candle(
    val close: Double,
    val datetime: Long,
    val high: Double,
    val low: Double,
    val `open`: Double,
    val volume: Int
)