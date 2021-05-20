package com.example.apistock.data.entities.quotes

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HistoricalData(
    val candles: List<Candle>,
    val empty: Boolean,
)