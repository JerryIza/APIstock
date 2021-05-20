package com.example.apistock.data.api

import dagger.Binds
import javax.inject.Inject


class MainRepository @Inject constructor(private val stockMarketService: StockMarketService) : BaseDataSource() {

    suspend fun getAllWatchlist() = getResults {
        stockMarketService.fetchWatchlistAsync("149235993", ""

        )
    }


    suspend fun getSymbolDetails(symbol: String) = getResults {
        stockMarketService.fetchSymbolDetailsAsync(
            symbol
        )
    }

    suspend fun getHistoricalData(
        symbol: String, periodType: String, periods: String, frequency: String
    ) = getResults {
        stockMarketService.fetchHistoricalDataAsync(
            symbol,
            periodType,
            periods,
            frequency
        )
    }

    suspend fun getSearchResults(symbol: String) = getResults {
        stockMarketService.fetchSearchSymbolsAsync(
            "$symbol.*",
            "symbol-regex"
        )
    }

    suspend fun getUserPrincipals() = getResults {
        stockMarketService.fetchUserPrincipalsAsync(
            "streamerSubscriptionKeys,streamerConnectionInfo"
        )
    }


    suspend fun postToken(grantType: String, refreshToken: String, accessType: String, code: String) = getResults {
        stockMarketService.fetchTokenAsync(
            grant_Type = grantType,
            refresh_Token = refreshToken,
            access_Type = accessType,
            Code = code,
            client_Id = "LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N@AMER.OAUTHAP",
            redirect_Uri = "http://localhost"
        )
    }


    suspend fun getAccountDetails() = getResults {
        stockMarketService.fetchAccountDetailsAsync("positions")
    }





}









