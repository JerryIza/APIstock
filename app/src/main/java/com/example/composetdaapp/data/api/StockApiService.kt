package com.example.composetdaapp.data.api


import com.example.composetdaapp.data.entities.account.Accounts
import com.example.composetdaapp.data.entities.orders.get.GetOrderItem
import com.example.composetdaapp.data.entities.orders.place.PlaceOrder
import com.example.composetdaapp.data.entities.quotes.HistoricalData
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.data.entities.token.TokenAccess
import com.example.composetdaapp.data.entities.user.UserPrincipals
import com.example.composetdaapp.data.entities.watchlist.Watchlist
import com.example.composetdaapp.data.entities.quotes.SymbolSearch
import retrofit2.Response
import retrofit2.http.*


const val API_KEY = "LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N"
//account number


interface StockApiService {

    //use Map for dynamic keys
    //@Headers("Authorization: Bearer: ${MyPreference.}")
    @GET("/v1/marketdata/quotes")
    suspend fun fetchSymbolDetailsAsync(@Query("symbol") symbol: String?): Response<MutableMap<String?, SymbolDetails>>

    //https://developer.tdameritrade.com/price-history/apis/get/marketdata/%7Bsymbol%7D/pricehistory#
    @GET("/v1/marketdata/{Symbol}/pricehistory")
    suspend fun fetchHistoricalDataAsync(
        @Path("Symbol") Symbol: String?,
        @Query("periodType") periodType: String?,
        @Query("period") period: String?,
        @Query("frequencyType") frequencyType: String?
    ): Response<HistoricalData>


       //https://developer.tdameritrade.com/price-history/apis/get/marketdata/%7Bsymbol%7D/pricehistory#
    @GET("/v1/marketdata/{Symbol}/pricehistory")
    suspend fun fetchIntraDayHistoricalAsync(
           @Path("Symbol") Symbol: String?,
           @Query("startDate") startDate: String?,
        @Query("endDate") endDate: String?,
        @Query("needExtendedHoursData") needExtendedHoursData: String?,
    ): Response<HistoricalData>

    @GET("/v1/instruments")
    suspend fun fetchSearchSymbolsAsync(
        @Query("symbol") Symbol: String?,
        @Query("projection") Projection: String?
    ): Response<MutableMap<String, SymbolSearch>>

    @Headers("Content-Type:application/json")
    @POST("/v1/accounts/{AccountNumber}/orders")
    suspend fun placeOrderAsync(
        @Path("AccountNumber") accountNumber: String?,
        @Body body: PlaceOrder
    ): Response<String>


    //Get orders by query
    @GET("/v1/orders")
    suspend fun fetchOrdersAsync(
        @Query("accountId") accountId: String,
        @Query("maxResults") maxResults: String,
        @Query("fromEnteredTime") fromEnteredTime: String?,
        @Query("toEnteredTime") toEnteredTime: String?,
        @Query("status") status: String,
    ) : Response<List<GetOrderItem>>


    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("/v1/oauth2/token")
    suspend fun postTokenAsync(
        @Field("grant_type") grant_Type: String,
        @Field("refresh_token") refresh_Token: String,
        @Field("access_type") access_Type: String,
        @Field("code") Code: String,
        @Field("client_id") client_Id: String,
        @Field("redirect_uri") redirect_Uri: String
    ): Response<TokenAccess>


    @PATCH("/v1/accounts/{AccountNumber}/watchlists/{watchlistId}")
    suspend fun patchWatchlistAsync(
        @Path("AccountNumber") accountNumber: String?,
        @Path("watchlistId") watchlistId: String?,
        @Body body: String
    ): Response<List<Watchlist>>

    //1568912277
    @GET("v1/accounts/{AccountNumber}/watchlists/{watchlistId}")
    suspend fun fetchWatchlistAsync(
        @Path("AccountNumber") accountNumber: String?,
        @Path("watchlistId") watchlistId: String?,
    ): Response<List<Watchlist>>


    @GET("/v1/userprincipals")
    suspend fun fetchUserPrincipalsAsync(
        @Query("fields") Fields: String
    ): Response<UserPrincipals>


    @GET("/v1/accounts/149235993")
    suspend fun fetchAccountDetailsAsync(
        @Query("fields") Fields: String
    ): Response<Accounts>


}














