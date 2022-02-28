package com.example.composetdaapp.data.entities.quotes

import com.example.composetdaapp.data.entities.quotes.Candle
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HistoricalData(
    val candles: List<Candle>,
    val empty: Boolean,
)