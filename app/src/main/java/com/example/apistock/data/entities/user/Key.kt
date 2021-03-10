package com.example.apistock.data.entities.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Key(
    @Json(name = "key")
    val key: String
)