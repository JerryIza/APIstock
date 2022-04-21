package com.example.composetdaapp.data.api

import com.example.composetdaapp.data.entities.orders.place.PlaceOrder
import javax.inject.Inject


class MainRepository @Inject constructor(private val stockMarketService: StockApiService) :
    BaseDataSource() {
    //get from user principals. Don't hard code account
    suspend fun getAllWatchlist() = getResults {
        stockMarketService.fetchWatchlistAsync(
            "149235993", ""

        )
    }

    suspend fun placeOrder(accNumber: String, order: PlaceOrder) = getResults {
        stockMarketService.placeOrderAsync(accNumber, order)
    }

    suspend fun getOrders()= getResults {
        stockMarketService.fetchOrdersAsync(
            accountId = "",
            maxResults = "",
            fromEnteredTime = null,
            toEnteredTime = null,
            status = ""
        )
    }

    suspend fun patchWatchlist(accNumber: String, watchlistId: String, body: String) = getResults {
        stockMarketService.patchWatchlistAsync(
            accountNumber = accNumber,
            watchlistId = watchlistId,
            body = body
        )
    }

    suspend fun getAccountDetails() = getResults {
        stockMarketService.fetchAccountDetailsAsync("positions")
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

    suspend fun getIntraDayHistorical(
        symbol: String,
        startDate: String,
        endDate: String,
        needExtendedHoursData: String
    ) = getResults {
        stockMarketService.fetchIntraDayHistoricalAsync(
            symbol,
            startDate,
            endDate,
            needExtendedHoursData
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


    suspend fun postToken(
        grantType: String,
        refreshToken: String,
        accessType: String,
        code: String
    ) = getResults {
        stockMarketService.postTokenAsync(
            grant_Type = grantType,
            refresh_Token = refreshToken,
            access_Type = accessType,
            Code = code,
            client_Id = "$API_KEY@AMER.OAUTHAP",
            redirect_Uri = "http://localhost"
        )
    }


    suspend fun postRefreshToken(refreshToken: String, accessType: String, code: String) =
        getResults {
            stockMarketService.postTokenAsync(
                grant_Type = "refresh_token",
                refresh_Token = refreshToken,
                access_Type = accessType,
                Code = code,
                client_Id = ("$API_KEY@AMER.OAUTHAP"),
                redirect_Uri = "http://localhost"
            )
        }


}









