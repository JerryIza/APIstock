package com.example.apistock.data.api

import com.example.apistock.data.api.BaseDataSource
import com.example.apistock.data.api.MarketMoversService
import com.example.apistock.ui.fragments.inputSymbol


class SymbolRepo(private val apiInterface: MarketMoversService) : BaseDataSource() {

    suspend fun getMarketMoversDetails() = getResults { apiInterface.fetchMoversDetailsAsync(inputSymbol) }

    suspend fun getSymbolDetails(symbol: String) = getResults { apiInterface.fetchSymbolDetailsAsync(symbol)}

    suspend fun getHistoricalData(symbol: String) = getResults { apiInterface.fetchHistoricalDataAsync(symbol, "month", "1", "daily") }
}


