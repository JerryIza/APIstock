package com.example.composetdaapp.ui.views.home
/*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.data.entities.watchlist.Watchlist
import com.example.composetdaapp.ui.viewmodels.MarketViewModel
import com.example.composetdaapp.utils.Resource
import kotlinx.coroutines.NonCancellable.isActive
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun WatchlistScreen() {
    val viewModel = hiltViewModel<MarketViewModel>()
    val watchlistState: State<List<Watchlist>?> = viewModel.watchlists.observeAsState()
    val watchlist: List<Watchlist>? = watchlistState.value // allow smart cast
    val watchlistPosState: State<Int?> = viewModel.watchlistPos.observeAsState()
    val watchlistPos: Int? = watchlistPosState.value
    var symbols: String = ""
    val symbolDetailsState: State<List<SymbolDetails>?> = viewModel.watchlistQuotes.observeAsState()
    val symbolDetails = symbolDetailsState
    val composableScope = rememberCoroutineScope()
    val stringBuilder = StringBuilder()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            if (watchlist == null && watchlistPos == null) {
                //prevents request after every redraw, when picking list
                viewModel.getAllWatchlist()


            } else if (watchlist != null && watchlistPos != null) {
                for (i in watchlist[watchlistPos].watchlistItems.indices) {
                    stringBuilder.append(watchlist[watchlistPos].watchlistItems[i].instrument.symbol + ",")
                }
                viewModel.getMultiSymbolDetails(stringBuilder.toString())
                symbols = stringBuilder.toString()
                stringBuilder.clear()
                items(watchlist.size) { index ->
                    symbolDetails.value?.let {
                        WatchlistView(
                            watchlist[watchlistPos],
                            it, index
                        )
                    }

                }
            }
            composableScope.launch {
                while (isActive) {
                    //we need to get watchlist first and use string builder
                    if (symbols.isNotEmpty()) {
                        viewModel.getMultiSymbolDetails(symbols)

                    }
                    delay(10000)
                }
            }
        }

        watchlist?.let {  WatchlistSpinner( watchlist = it)
            println("WATTTTTTTTCH THIS BITCH : "+ it)

        }
        //watchlist?.let {  WatchlistSelectionSpinner( watchlist = it)}


    }
}
*/