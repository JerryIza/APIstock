package com.example.apistock.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020BJ\u0006\u0010E\u001a\u00020FJ\u001e\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007J%\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0(H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010NJ\u000e\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020F2\u0006\u0010R\u001a\u00020\u0007J\u0006\u0010S\u001a\u00020FJ\u000e\u0010T\u001a\u00020F2\u0006\u0010R\u001a\u00020\u0007J\u0006\u0010U\u001a\u00020FR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR&\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R#\u0010\'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\t0(0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020/0.0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R+\u00102\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u0002030.0(0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR&\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060(0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u00109\u001a\u00020:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006V"}, d2 = {"Lcom/example/apistock/ui/viewmodels/MarketMoversViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/apistock/data/api/SymbolRepo;", "(Lcom/example/apistock/data/api/SymbolRepo;)V", "_symbol", "Landroidx/lifecycle/MutableLiveData;", "", "candleEntries", "", "Lcom/github/mikephil/charting/data/CandleEntry;", "getCandleEntries", "()Ljava/util/List;", "setCandleEntries", "(Ljava/util/List;)V", "chartLiveData", "Landroidx/lifecycle/MediatorLiveData;", "getChartLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "indicatorEntries", "", "Lcom/github/mikephil/charting/data/Entry;", "getIndicatorEntries", "setIndicatorEntries", "indicatorLiveData", "getIndicatorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setIndicatorLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob", "()Lkotlinx/coroutines/CompletableJob;", "setJob", "(Lkotlinx/coroutines/CompletableJob;)V", "moversLiveData", "Lcom/example/apistock/utils/Resource;", "Lcom/example/apistock/data/entities/MarketMovers;", "getMoversLiveData", "scope", "Lkotlinx/coroutines/CoroutineScope;", "searchResultsLiveData", "", "Lcom/example/apistock/data/entities/SymbolSearch;", "getSearchResultsLiveData", "setSearchResultsLiveData", "symbolLiveData", "Lcom/example/apistock/data/entities/SymbolDetails;", "getSymbolLiveData", "tempCredentialsLiveData", "Lcom/example/apistock/data/entities/user/UserPrincipals;", "getTempCredentialsLiveData", "setTempCredentialsLiveData", "upperIndicators", "Lcom/example/apistock/indicators/UpperIndicators;", "getUpperIndicators", "()Lcom/example/apistock/indicators/UpperIndicators;", "setUpperIndicators", "(Lcom/example/apistock/indicators/UpperIndicators;)V", "get52WeekHighLow", "", "last", "", "low", "high", "getAccountDetails", "", "getChartData", "periodType", "period", "frequency", "getIndicatorData", "historicalData", "Lcom/example/apistock/data/entities/HistoricalData;", "(Lcom/example/apistock/utils/Resource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoversDetails", "market", "getSearchResults", "symbol", "getSymbolDetails", "start", "tempUserPrincipals", "app_debug"})
public final class MarketMoversViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.CompletableJob job;
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _symbol = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.apistock.utils.Resource<java.util.List<com.example.apistock.data.entities.MarketMovers>>> moversLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.apistock.utils.Resource<java.util.Map<java.lang.String, com.example.apistock.data.entities.SymbolDetails>>> symbolLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private com.example.apistock.indicators.UpperIndicators upperIndicators;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<java.util.List<com.github.mikephil.charting.data.CandleEntry>> chartLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.github.mikephil.charting.data.CandleEntry> candleEntries;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<? extends com.github.mikephil.charting.data.Entry> indicatorEntries;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.Entry>> indicatorLiveData;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, com.example.apistock.data.entities.SymbolSearch>> searchResultsLiveData;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.apistock.utils.Resource<com.example.apistock.data.entities.user.UserPrincipals>> tempCredentialsLiveData;
    private final com.example.apistock.data.api.SymbolRepo repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CompletableJob getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CompletableJob p0) {
    }
    
    private final kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.apistock.utils.Resource<java.util.List<com.example.apistock.data.entities.MarketMovers>>> getMoversLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.apistock.utils.Resource<java.util.Map<java.lang.String, com.example.apistock.data.entities.SymbolDetails>>> getSymbolLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.indicators.UpperIndicators getUpperIndicators() {
        return null;
    }
    
    public final void setUpperIndicators(@org.jetbrains.annotations.NotNull()
    com.example.apistock.indicators.UpperIndicators p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.github.mikephil.charting.data.CandleEntry>> getChartLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.github.mikephil.charting.data.CandleEntry> getCandleEntries() {
        return null;
    }
    
    public final void setCandleEntries(@org.jetbrains.annotations.NotNull()
    java.util.List<com.github.mikephil.charting.data.CandleEntry> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.github.mikephil.charting.data.Entry> getIndicatorEntries() {
        return null;
    }
    
    public final void setIndicatorEntries(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.github.mikephil.charting.data.Entry> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.Entry>> getIndicatorLiveData() {
        return null;
    }
    
    public final void setIndicatorLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.Entry>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, com.example.apistock.data.entities.SymbolSearch>> getSearchResultsLiveData() {
        return null;
    }
    
    public final void setSearchResultsLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, com.example.apistock.data.entities.SymbolSearch>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.apistock.utils.Resource<com.example.apistock.data.entities.user.UserPrincipals>> getTempCredentialsLiveData() {
        return null;
    }
    
    public final void setTempCredentialsLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.apistock.utils.Resource<com.example.apistock.data.entities.user.UserPrincipals>> p0) {
    }
    
    public final void start(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol) {
    }
    
    public final void getChartData(@org.jetbrains.annotations.NotNull()
    java.lang.String periodType, @org.jetbrains.annotations.NotNull()
    java.lang.String period, @org.jetbrains.annotations.NotNull()
    java.lang.String frequency) {
    }
    
    public final void getSearchResults(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol) {
    }
    
    public final void getSymbolDetails() {
    }
    
    public final void getMoversDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String market) {
    }
    
    public final int get52WeekHighLow(double last, double low, double high) {
        return 0;
    }
    
    public final void tempUserPrincipals() {
    }
    
    public final void getAccountDetails() {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public MarketMoversViewModel(@org.jetbrains.annotations.NotNull()
    com.example.apistock.data.api.SymbolRepo repository) {
        super();
    }
}