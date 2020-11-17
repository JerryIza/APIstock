package com.example.apistock.data.entities

import com.github.mikephil.charting.data.CandleEntry


data class HistoricalData(
    val candles: List<Candle>,
    val empty: Boolean,
)