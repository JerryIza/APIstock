package com.example.composetdaapp.data.entities.user


import com.example.composetdaapp.data.entities.user.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserPrincipals(
    @Json(name = "accessLevel")
    val accessLevel: String,
    @Json(name = "accounts")
    val accounts: List<Account>,
    @Json(name = "exchangeAgreements")
    val exchangeAgreements: ExchangeAgreements,
    @Json(name = "lastLoginTime")
    val lastLoginTime: String,
    @Json(name = "loginTime")
    val loginTime: String,
    @Json(name = "primaryAccountId")
    val primaryAccountId: String,
    @Json(name = "professionalStatus")
    val professionalStatus: String,
    @Json(name = "quotes")
    val quotes: Quotes,
    @Json(name = "stalePassword")
    val stalePassword: Boolean,
    @Json(name = "streamerInfo")
    val streamerInfo: StreamerInfo,
    @Json(name = "streamerSubscriptionKeys")
    val streamerSubscriptionKeys: StreamerSubscriptionKeys,
    @Json(name = "tokenExpirationTime")
    val tokenExpirationTime: String,
    @Json(name = "userCdDomainId")
    val userCdDomainId: String,
    @Json(name = "userId")
    val userId: String
)