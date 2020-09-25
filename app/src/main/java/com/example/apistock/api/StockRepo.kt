package com.example.apistock.api

import com.example.apistock.overview.inputSymbol


class StockRepo(private val apiInterface: StockApiInterface) : BaseRepository() {
    //private var urlStock = base("T")
    //get stock using safe api call
    suspend fun getStockDetails() : MutableList<SymbolDetails>?{
        return safeApiCall(
            //await the result of deferred type
            call = {apiInterface.fetchSymbolDetailsAsync(inputSymbol)},
            error = "error fetching stock details"
            //convert to mutable list
        )
    }
}

