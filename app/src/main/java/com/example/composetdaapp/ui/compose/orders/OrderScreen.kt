package com.example.composetdaapp.ui.compose.orders

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetdaapp.R
import com.example.composetdaapp.ui.viewmodels.MarketViewModel


@ExperimentalAnimationApi
@Composable
fun OrderScreen() {
    val viewModel = hiltViewModel<MarketViewModel>()
    val orders = viewModel.cards.collectAsState()
    val expandedCardIds = viewModel.expandedCardIdsList.collectAsState()
    Scaffold(
        backgroundColor = Color(
            ContextCompat.getColor(
                LocalContext.current,
                R.color.cardview_dark_background

            )
        )
    ) {
        viewModel.getOrders()
        LazyColumn {
            itemsIndexed(orders.value) { _, order ->
                ExpandableList(
                    order = order,
                    onCardArrowClick = { viewModel.onCardArrowClicked(order.orderId?.toInt()) },
                    expanded = expandedCardIds.value.contains(order.orderId?.toInt()),
                )
            }
        }
    }
}