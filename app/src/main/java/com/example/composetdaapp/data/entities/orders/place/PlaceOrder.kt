package com.example.composetdaapp.data.entities.orders.place

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaceOrder(
    var duration: String? = null,
    val orderLegCollection: List<OrderLegCollection>,
    val orderStrategyType: String,
    var orderType: String? = null,
    var price: String? = null,
    var session: String? = null
)

