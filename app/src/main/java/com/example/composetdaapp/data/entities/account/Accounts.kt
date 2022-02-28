package com.example.composetdaapp.data.entities.account


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Accounts(
    @Json(name = "securitiesAccount")
    val securitiesAccount: SecuritiesAccount
)