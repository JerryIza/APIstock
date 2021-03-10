package com.example.apistock.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J+\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180\u00170\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J-\u0010\u0019\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u001a0\u00170\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u001f\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/example/apistock/data/api/SymbolRepo;", "Lcom/example/apistock/data/api/BaseDataSource;", "stockMarketService", "Lcom/example/apistock/data/api/StockMarketService;", "(Lcom/example/apistock/data/api/StockMarketService;)V", "getAccountDetails", "Lcom/example/apistock/utils/Resource;", "Lcom/example/apistock/data/entities/account/Accounts;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistoricalData", "Lcom/example/apistock/data/entities/HistoricalData;", "symbol", "", "periodType", "periods", "frequency", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMarketMoversDetails", "", "Lcom/example/apistock/data/entities/MarketMovers;", "market", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchResults", "", "Lcom/example/apistock/data/entities/SymbolSearch;", "getSymbolDetails", "Lcom/example/apistock/data/entities/SymbolDetails;", "getUserPrincipals", "Lcom/example/apistock/data/entities/user/UserPrincipals;", "postToken", "Lcom/example/apistock/data/entities/token/TokenAccess;", "code", "app_debug"})
public final class SymbolRepo extends com.example.apistock.data.api.BaseDataSource {
    private final com.example.apistock.data.api.StockMarketService stockMarketService = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMarketMoversDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String market, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.apistock.utils.Resource<? extends java.util.List<com.example.apistock.data.entities.MarketMovers>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSymbolDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.apistock.utils.Resource<? extends java.util.Map<java.lang.String, com.example.apistock.data.entities.SymbolDetails>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHistoricalData(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    java.lang.String periodType, @org.jetbrains.annotations.NotNull()
    java.lang.String periods, @org.jetbrains.annotations.NotNull()
    java.lang.String frequency, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.apistock.utils.Resource<com.example.apistock.data.entities.HistoricalData>> p4) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSearchResults(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.apistock.utils.Resource<? extends java.util.Map<java.lang.String, com.example.apistock.data.entities.SymbolSearch>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserPrincipals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.apistock.utils.Resource<com.example.apistock.data.entities.user.UserPrincipals>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object postToken(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.apistock.utils.Resource<com.example.apistock.data.entities.token.TokenAccess>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAccountDetails(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.apistock.utils.Resource<com.example.apistock.data.entities.account.Accounts>> p0) {
        return null;
    }
    
    @javax.inject.Inject()
    public SymbolRepo(@org.jetbrains.annotations.NotNull()
    com.example.apistock.data.api.StockMarketService stockMarketService) {
        super();
    }
}