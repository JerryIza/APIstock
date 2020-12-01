package com.example.apistock.data.api

import javax.inject.Inject


class SymbolRepo @Inject constructor(private val stockMarketService: StockMarketService) : BaseDataSource() {

    suspend fun getMarketMoversDetails(market: String) = getResults { stockMarketService.fetchMoversDetailsAsync(market) }

    suspend fun getSymbolDetails(symbol: String) = getResults { stockMarketService.fetchSymbolDetailsAsync(symbol)}

    suspend fun getHistoricalData(symbol: String, periodType: String, periods: String, frequency: String) = getResults { stockMarketService.fetchHistoricalDataAsync(symbol, periodType, periods, frequency) }

    suspend fun getSearchResults(symbol: String) = getResults { stockMarketService.fetchSearchSymbolsAsync("${symbol}.*", "symbol-regex") }

}


