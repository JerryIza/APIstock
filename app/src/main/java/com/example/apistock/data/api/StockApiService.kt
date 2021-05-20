package com.example.apistock.data.api


import com.example.apistock.data.entities.*
import com.example.apistock.data.entities.account.Accounts
import com.example.apistock.data.entities.quotes.HistoricalData
import com.example.apistock.data.entities.quotes.SymbolDetails
import com.example.apistock.data.entities.user.UserPrincipals
import com.example.apistock.data.entities.token.TokenAccess
import com.example.apistock.data.entities.watchlist.Watchlist
import retrofit2.Response
import retrofit2.http.*


const val API_KEY = "LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N"


interface StockMarketService {

    //use Map for dynamic keys
    //@Headers("Authorization: Bearer: ${MyPreference.}")
    @GET("/v1/marketdata/quotes")
    suspend fun fetchSymbolDetailsAsync(@Query("symbol") symbol: String?): Response<MutableMap<String?, SymbolDetails>>

    @GET("/v1/marketdata/{Symbol}/pricehistory")
    suspend fun fetchHistoricalDataAsync(
        @Path("Symbol") Symbol: String?,
        @Query("periodType") periodType: String?,
        @Query("period") period: String?,
        @Query("frequencyType") frequencyType: String?
    ): Response<HistoricalData>

    @GET("/v1/instruments")
    suspend fun fetchSearchSymbolsAsync(
        @Query("symbol") Symbol: String?,
        @Query("projection") Projection: String?
    ): Response<MutableMap<String, SymbolSearch>>

    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("/v1/oauth2/token")
    suspend fun fetchTokenAsync(
        @Field("grant_type") grant_Type: String,
        @Field("refresh_token") refresh_Token: String,
        @Field("access_type") access_Type: String,
        @Field("code") Code: String,
        @Field("client_id") client_Id: String,
        @Field("redirect_uri") redirect_Uri : String
    ): Response<TokenAccess>


    @GET("/v1/userprincipals")
    suspend fun fetchUserPrincipalsAsync(
        @Query("fields") Fields: String
    ): Response<UserPrincipals>


    @GET("/v1/accounts/149235993")
    suspend fun fetchAccountDetailsAsync(
        @Query("fields") Fields: String
    ): Response<Accounts>


    //1568912277
    @GET("v1/accounts/{AccountNumber}/watchlists/{watchlistId}")
    suspend fun fetchWatchlistAsync(
        @Path("AccountNumber") accountNumber: String?,
        @Path("watchlistId") watchlistId: String?,
    ): Response<List<Watchlist>>


}














