package com.example.composetdaapp.data.entities.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExchangeAgreements(
    @Json(name = "NASDAQ_EXCHANGE_AGREEMENT")
    val nASDAQEXCHANGEAGREEMENT: String,
    @Json(name = "NYSE_EXCHANGE_AGREEMENT")
    val nYSEEXCHANGEAGREEMENT: String,
    @Json(name = "OPRA_EXCHANGE_AGREEMENT")
    val oPRAEXCHANGEAGREEMENT: String
)