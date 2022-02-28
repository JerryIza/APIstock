package com.example.composetdaapp.data.entities.quotes


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SymbolDetails(
    val askId: String? = null,
    val askPrice: Double? = null,
    val askSize: Int? = null,
    val assetMainType: String,
    val assetType: String,
    val bidId: String? = null,
    val bidPrice: Double? = null,
    val bidSize: Int? = null,
    val bidTick: String? = null,
    val closePrice: Double,
    val cusip: String,
    val delayed: Boolean,
    val description: String,
    val digits: Int,
    val divAmount: Double? = null,
    val divDate: String? = null,
    val divYield: Double? = null,
    val exchange: String,
    val exchangeName: String,
    val highPrice: Double,
    val lastId: String? = null,
    val lastPrice: Double,
    val lastSize: Int? = null,
    val lowPrice: Double,
    val marginable: Boolean? = null,
    val mark: Double? = null,
    val markChangeInDouble: Double? = null,
    val markPercentChangeInDouble: Double? = null,
    val nAV: Double? = null,
    val netChange: Double,
    val netPercentChangeInDouble: Double,
    val openPrice: Double,
    val peRatio: Double? = null,
    val quoteTimeInLong: Long? = null,
    val regularMarketLastPrice: Double? = null,
    val regularMarketLastSize: Int? = null,
    val regularMarketNetChange: Double? = null,
    val regularMarketPercentChangeInDouble: Double? = null,
    val regularMarketTradeTimeInLong: Long? = null,
    val securityStatus: String,
    val shortable: Boolean? = null,
    val symbol: String,
    val totalVolume: Int,
    val tradeTimeInLong: Long,
    //ok? front, back, implied, historical???
    val volatility: Double? = null,
    @field:Json(name = "52WkHigh")
    val wkHigh: Double? = null,
    @field:Json(name = "52WkLow")
    val wkLow: Double? = null
)