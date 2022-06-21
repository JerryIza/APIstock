package com.example.composetdaapp.data.entities.websocket.login

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
// Exception to not use camelCase, leads to encoder problems
@JsonClass(generateAdapter = true)
data class Credentials(
    @Json(name = "userid")
    val userid: String,
    @Json(name = "token")
    val token: String,
    @Json(name = "company")
    val company: String,
    @Json(name = "segment")
    val segment: String,
    @Json(name = "cddomain")
    val cddomain: String,
    @Json(name = "usergroup")
    val usergroup: String,
    @Json(name = "accesslevel")
    val accesslevel: String,
    @Json(name = "auhtorized")
    val authorized: String = "Y",
    @Json(name = "timestamp")
    val timestamp: Long,
    @Json(name = "appid")
    val appid: String,
    @Json(name = "acl")
    val acl: String,
    )
