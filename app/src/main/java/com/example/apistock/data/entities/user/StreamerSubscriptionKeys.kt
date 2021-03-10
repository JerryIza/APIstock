package com.example.apistock.data.entities.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StreamerSubscriptionKeys(
    @Json(name = "keys")
    val keys: List<Key>
)