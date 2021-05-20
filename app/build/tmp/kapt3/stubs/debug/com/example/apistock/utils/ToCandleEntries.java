package com.example.apistock.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a8\u0006\u000f"}, d2 = {"Lcom/example/apistock/utils/ToCandleEntries;", "", "()V", "lastCandleUpdate", "", "Lcom/github/mikephil/charting/data/CandleEntry;", "candleEntries", "symbolDetails", "Lcom/example/apistock/data/entities/quotes/SymbolDetails;", "historicalDataSize", "", "toCandleEntry", "historicalData", "Lcom/example/apistock/utils/Resource;", "Lcom/example/apistock/data/entities/quotes/HistoricalData;", "app_debug"})
public final class ToCandleEntries {
    public static final com.example.apistock.utils.ToCandleEntries INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.github.mikephil.charting.data.CandleEntry> toCandleEntry(@org.jetbrains.annotations.NotNull()
    com.example.apistock.utils.Resource<com.example.apistock.data.entities.quotes.HistoricalData> historicalData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.github.mikephil.charting.data.CandleEntry> lastCandleUpdate(@org.jetbrains.annotations.NotNull()
    java.util.List<com.github.mikephil.charting.data.CandleEntry> candleEntries, @org.jetbrains.annotations.NotNull()
    com.example.apistock.data.entities.quotes.SymbolDetails symbolDetails, int historicalDataSize) {
        return null;
    }
    
    private ToCandleEntries() {
        super();
    }
}