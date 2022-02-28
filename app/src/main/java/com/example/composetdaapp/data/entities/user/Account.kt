package com.example.composetdaapp.data.entities.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Account(
    @Json(name = "accountCdDomainId")
    val accountCdDomainId: String,
    @Json(name = "accountId")
    val accountId: String,
    @Json(name = "acl")
    val acl: String,
    @Json(name = "authorizations")
    val authorizations: Authorizations,
    @Json(name = "company")
    val company: String,
    @Json(name = "displayName")
    val displayName: String,
    @Json(name = "segment")
    val segment: String
)