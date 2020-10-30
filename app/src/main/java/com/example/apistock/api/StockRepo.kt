package com.example.apistock.api

import com.example.apistock.ui.fragments.inputSymbol
import com.example.apistock.utils.Resource


class StockRepo(private val apiInterface: MarketMoversService) : BaseDataSource() {

    suspend fun getMarketMoversDetails() =
        getResults { apiInterface.fetchSymbolDetailsAsync(inputSymbol) }

}

