package com.example.composetdaapp.data.entities.quotes


import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class SymbolSearch(
    val description: String,
    val symbol: String
)