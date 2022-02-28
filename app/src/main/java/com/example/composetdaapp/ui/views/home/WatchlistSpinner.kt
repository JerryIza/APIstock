package com.example.composetdaapp.ui.views.home
/*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetdaapp.data.entities.account.Positions
import com.example.composetdaapp.data.entities.watchlist.Watchlist
import com.example.composetdaapp.ui.viewmodels.MarketViewModel



@ExperimentalMaterialApi
@Composable
fun WatchlistSpinner(watchlist: List<Watchlist>) {


    val viewModel = hiltViewModel<MarketViewModel>()
    val options = arrayListOf<String>()
    val text = remember { mutableStateOf(watchlist[0].name) } // initial value

    watchlist.forEach { options.add(it.name) }

    println("delete this: " + options)

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }


    val userSelectedPos: (Int) -> Unit = {
        viewModel._watchlistPos.value = it

    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            label = { Text("Watchlist") },
            trailingIcon = {
                TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                        //get quotes for selected watchlist, might have to clear this when a new value is selev
                        viewModel._watchlistPos.postValue(options.indexOf(selectedOptionText))
                    }
                ) {

                    Text(text = selectionOption)
                }
            }
        }
    }


}



*/