package com.example.composetdaapp.ui.views.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.data.entities.watchlist.Watchlist


//WatchlistItems
//@PreviewParameter
@Composable
fun WatchlistView(watchlist: Watchlist, symbolQuotes: List<SymbolDetails>, Pos: Int) {

    // Each cell of a column must have the same weight.
    val column1Weight = .2f // 30%
    val column2Weight = .25f // 70%


    //Header

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(modifier = Modifier.weight(column1Weight)) {

                Text(text = watchlist.watchlistItems[Pos].instrument.symbol)
                Text(text = symbolQuotes[Pos].description, fontSize = 9.sp
                )
            }


            Column(
                modifier = Modifier.weight(column2Weight),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,

                ) {

                Text(
                    textAlign = TextAlign.Center,

                    text = "$%,.2f".format(symbolQuotes[Pos].lastPrice)
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = ("%,.2f".format(symbolQuotes[Pos].regularMarketNetChange) + " (" + ("%,.2f".format(
                        symbolQuotes[Pos].regularMarketPercentChangeInDouble?.times(100)
                    ) + "%") + ")")
                )
            }


        }
    }


}




