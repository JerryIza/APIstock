package com.example.apistock.data.entities.account


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Position(
    @Json(name = "averagePrice")
    val averagePrice: Double,
    @Json(name = "currentDayProfitLoss")
    val currentDayProfitLoss: Double,
    @Json(name = "currentDayProfitLossPercentage")
    val currentDayProfitLossPercentage: Double,
    @Json(name = "instrument")
    val instrument: Instrument,
    @Json(name = "longQuantity")
    val longQuantity: Double,
    @Json(name = "maintenanceRequirement")
    val maintenanceRequirement: Double,
    @Json(name = "marketValue")
    val marketValue: Double,
    @Json(name = "settledLongQuantity")
    val settledLongQuantity: Double,
    @Json(name = "settledShortQuantity")
    val settledShortQuantity: Int,
    @Json(name = "shortQuantity")
    val shortQuantity: Int
)