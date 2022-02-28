package com.example.composetdaapp.data.entities.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StreamerInfo(
    @Json(name = "accessLevel")
    val accessLevel: String,
    @Json(name = "acl")
    val acl: String,
    @Json(name = "appId")
    val appId: String,
    @Json(name = "streamerBinaryUrl")
    val streamerBinaryUrl: String,
    @Json(name = "streamerSocketUrl")
    val streamerSocketUrl: String,
    @Json(name = "token")
    val token: String,
    @Json(name = "tokenTimestamp")
    val tokenTimestamp: String,
    @Json(name = "userGroup")
    val userGroup: String
)