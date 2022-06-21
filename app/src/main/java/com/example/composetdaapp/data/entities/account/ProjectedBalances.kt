package com.example.composetdaapp.data.entities.account


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProjectedBalances(
    @Json(name = "availableFunds")
    val availableFunds: Double?,
    @Json(name = "availableFundsNonMarginableTrade")
    val availableFundsNonMarginableTrade: Double?,
    @Json(name = "buyingPower")
    val buyingPower: Double?,
    @Json(name = "dayTradingBuyingPower")
    val dayTradingBuyingPower: Int?,
    @Json(name = "dayTradingBuyingPowerCall")
    val dayTradingBuyingPowerCall: Int?,
    @Json(name = "isInCall")
    val isInCall: Boolean?,
    @Json(name = "maintenanceCall")
    val maintenanceCall: Double?,
    @Json(name = "regTCall")
    val regTCall: Int?,
    @Json(name = "stockBuyingPower")
    val stockBuyingPower: Double?
)