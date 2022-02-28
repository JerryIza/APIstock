package com.example.composetdaapp.data.entities.account


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentBalances(
    @Json(name = "accruedInterest")
    val accruedInterest: Double,
    @Json(name = "availableFunds")
    val availableFunds: Double,
    @Json(name = "availableFundsNonMarginableTrade")
    val availableFundsNonMarginableTrade: Double,
    @Json(name = "bondValue")
    val bondValue: Int,
    @Json(name = "buyingPower")
    val buyingPower: Double,
    @Json(name = "buyingPowerNonMarginableTrade")
    val buyingPowerNonMarginableTrade: Double,
    @Json(name = "cashBalance")
    val cashBalance: Double,
    @Json(name = "cashReceipts")
    val cashReceipts: Int,
    @Json(name = "dayTradingBuyingPower")
    val dayTradingBuyingPower: Int,
    @Json(name = "equity")
    val equity: Double,
    @Json(name = "equityPercentage")
    val equityPercentage: Double,
    @Json(name = "liquidationValue")
    val liquidationValue: Double,
    @Json(name = "longMarginValue")
    val longMarginValue: Double,
    @Json(name = "longMarketValue")
    val longMarketValue: Double,
    @Json(name = "longOptionMarketValue")
    val longOptionMarketValue: Double,
    @Json(name = "maintenanceCall")
    val maintenanceCall: Double,
    @Json(name = "maintenanceRequirement")
    val maintenanceRequirement: Double,
    @Json(name = "marginBalance")
    val marginBalance: Double,
    @Json(name = "moneyMarketFund")
    val moneyMarketFund: Double,
    @Json(name = "mutualFundValue")
    val mutualFundValue: Int,
    @Json(name = "pendingDeposits")
    val pendingDeposits: Int,
    @Json(name = "regTCall")
    val regTCall: Int,
    @Json(name = "savings")
    val savings: Int,
    @Json(name = "shortBalance")
    val shortBalance: Double,
    @Json(name = "shortMarginValue")
    val shortMarginValue: Double,
    @Json(name = "shortMarketValue")
    val shortMarketValue: Double,
    @Json(name = "shortOptionMarketValue")
    val shortOptionMarketValue: Double,
    @Json(name = "sma")
    val sma: Double
)