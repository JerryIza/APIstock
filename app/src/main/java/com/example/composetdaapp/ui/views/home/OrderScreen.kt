package com.example.composetdaapp.ui.views.home

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
    val cards = viewModel.cards.collectAsState()
    val expandedCardIds = viewModel.expandedCardIdsList.collectAsState()
    Scaffold(
        backgroundColor = Color(
            ContextCompat.getColor(
                LocalContext.current,
                R.color.cardview_dark_background

            )
        )
    ) {
        LazyColumn {
            itemsIndexed(cards.value) { _, card ->
                ExpandableList(
                    card = card,
                    onCardArrowClick = { viewModel.onCardArrowClicked(card.id) },
                    expanded = expandedCardIds.value.contains(card.id),
                )
            }
        }
    }
}