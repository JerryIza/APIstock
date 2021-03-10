package com.example.apistock.data.entities.account


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InitialBalances(
    @Json(name = "accountValue")
    val accountValue: Double,
    @Json(name = "accruedInterest")
    val accruedInterest: Int,
    @Json(name = "availableFundsNonMarginableTrade")
    val availableFundsNonMarginableTrade: Double,
    @Json(name = "bondValue")
    val bondValue: Int,
    @Json(name = "buyingPower")
    val buyingPower: Int,
    @Json(name = "cashAvailableForTrading")
    val cashAvailableForTrading: Int,
    @Json(name = "cashBalance")
    val cashBalance: Double,
    @Json(name = "cashReceipts")
    val cashReceipts: Int,
    @Json(name = "dayTradingBuyingPower")
    val dayTradingBuyingPower: Int,
    @Json(name = "dayTradingBuyingPowerCall")
    val dayTradingBuyingPowerCall: Int,
    @Json(name = "dayTradingEquityCall")
    val dayTradingEquityCall: Int,
    @Json(name = "equity")
    val equity: Double,
    @Json(name = "equityPercentage")
    val equityPercentage: Int,
    @Json(name = "isInCall")
    val isInCall: Boolean,
    @Json(name = "liquidationValue")
    val liquidationValue: Double,
    @Json(name = "longMarginValue")
    val longMarginValue: Int,
    @Json(name = "longOptionMarketValue")
    val longOptionMarketValue: Int,
    @Json(name = "longStockValue")
    val longStockValue: Int,
    @Json(name = "maintenanceCall")
    val maintenanceCall: Int,
    @Json(name = "maintenanceRequirement")
    val maintenanceRequirement: Double,
    @Json(name = "margin")
    val margin: Double,
    @Json(name = "marginBalance")
    val marginBalance: Int,
    @Json(name = "marginEquity")
    val marginEquity: Double,
    @Json(name = "moneyMarketFund")
    val moneyMarketFund: Double,
    @Json(name = "mutualFundValue")
    val mutualFundValue: Int,
    @Json(name = "pendingDeposits")
    val pendingDeposits: Int,
    @Json(name = "regTCall")
    val regTCall: Int,
    @Json(name = "shortBalance")
    val shortBalance: Double,
    @Json(name = "shortMarginValue")
    val shortMarginValue: Double,
    @Json(name = "shortOptionMarketValue")
    val shortOptionMarketValue: Int,
    @Json(name = "shortStockValue")
    val shortStockValue: Double,
    @Json(name = "totalCash")
    val totalCash: Int
)