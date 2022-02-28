package com.example.composetdaapp.data.entities.orders.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetOrderItem(
    @Json(name = "accountId")
    val accountId: Int,
    @Json(name = "cancelable")
    val cancelable: Boolean,
    @Json(name = "complexOrderStrategyType")
    val complexOrderStrategyType: String,
    @Json(name = "destinationLinkName")
    val destinationLinkName: String,
    @Json(name = "duration")
    val duration: String,
    @Json(name = "editable")
    val editable: Boolean,
    @Json(name = "enteredTime")
    val enteredTime: String,
    @Json(name = "filledQuantity")
    val filledQuantity: Int,
    @Json(name = "orderId")
    val orderId: Long? = null,
    @Json(name = "orderLegCollection")
    val orderLegCollection: List<OrderLegCollection>,
    @Json(name = "orderStrategyType")
    val orderStrategyType: String,
    @Json(name = "orderType")
    val orderType: String,
    @Json(name = "price")
    val price: Double,
    @Json(name = "quantity")
    val quantity: Int,
    @Json(name = "remainingQuantity")
    val remainingQuantity: Int,
    @Json(name = "requestedDestination")
    val requestedDestination: String,
    @Json(name = "session")
    val session: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "tag")
    val tag: String
)