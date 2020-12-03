package com.example.apistock.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class SymbolSearch(
    val assetType: String,
    val cusip: String,
    val description: String,
    val exchange: String,
    val symbol: String
)