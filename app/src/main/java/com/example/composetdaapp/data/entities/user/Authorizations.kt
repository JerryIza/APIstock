package com.example.composetdaapp.data.entities.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Authorizations(
    @Json(name = "advancedMargin")
    val advancedMargin: Boolean,
    @Json(name = "apex")
    val apex: Boolean,
    @Json(name = "levelTwoQuotes")
    val levelTwoQuotes: Boolean,
    @Json(name = "marginTrading")
    val marginTrading: Boolean,
    @Json(name = "optionTradingLevel")
    val optionTradingLevel: String,
    @Json(name = "scottradeAccount")
    val scottradeAccount: Boolean,
    @Json(name = "stockTrading")
    val stockTrading: Boolean,
    @Json(name = "streamerAccess")
    val streamerAccess: Boolean,
    @Json(name = "streamingNews")
    val streamingNews: Boolean
)