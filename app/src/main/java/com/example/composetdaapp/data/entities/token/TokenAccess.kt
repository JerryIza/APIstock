package com.example.composetdaapp.data.entities.token


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenAccess(
    @Json(name = "access_token")
    val accessToken: String? = null,
    @Json(name = "expires_in")
    val expiresIn: Int,
    @Json(name = "refresh_token")
    val refreshToken: String? = null,
    @Json(name = "refresh_token_expires_in")
    val refreshTokenExpiresIn: Int? = null,
    @Json(name = "scope")
    val scope: String,
    @Json(name = "token_type")
    val tokenType: String
)