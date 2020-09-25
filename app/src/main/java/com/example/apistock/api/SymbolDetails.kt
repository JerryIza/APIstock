package com.example.apistock.api


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class SymbolDetails(
    val symbol: String,
    val description : String,
    val cusip : String
)