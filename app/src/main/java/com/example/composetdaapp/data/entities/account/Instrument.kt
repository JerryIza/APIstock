package com.example.composetdaapp.data.entities.account


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Instrument(
    @Json(name = "assetType")
    val assetType: String,
    @Json(name = "cusip")
    val cusip: String,
    @Json(name = "symbol")
    val symbol: String,
    @Json(name = "description")
    val description: String?,
    @Json(name = "type")
    val type: String?
)