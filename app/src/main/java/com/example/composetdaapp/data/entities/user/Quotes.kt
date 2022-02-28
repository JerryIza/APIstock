package com.example.composetdaapp.data.entities.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Quotes(
    @Json(name = "isAmexDelayed")
    val isAmexDelayed: Boolean,
    @Json(name = "isCmeDelayed")
    val isCmeDelayed: Boolean,
    @Json(name = "isForexDelayed")
    val isForexDelayed: Boolean,
    @Json(name = "isIceDelayed")
    val isIceDelayed: Boolean,
    @Json(name = "isNasdaqDelayed")
    val isNasdaqDelayed: Boolean,
    @Json(name = "isNyseDelayed")
    val isNyseDelayed: Boolean,
    @Json(name = "isOpraDelayed")
    val isOpraDelayed: Boolean
)