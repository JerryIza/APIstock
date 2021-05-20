package com.example.apistock.data.entities.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bU\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0007\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010 J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0007H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0007H\u00c6\u0003J\t\u0010L\u001a\u00020\u0007H\u00c6\u0003J\t\u0010M\u001a\u00020\u0007H\u00c6\u0003J\t\u0010N\u001a\u00020\u0007H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\t\u0010U\u001a\u00020\u0007H\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0007H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0007H\u00c6\u0003J\u00a1\u0002\u0010[\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u00072\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00072\b\b\u0003\u0010\u0014\u001a\u00020\u00032\b\b\u0003\u0010\u0015\u001a\u00020\u00032\b\b\u0003\u0010\u0016\u001a\u00020\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00072\b\b\u0003\u0010\u0018\u001a\u00020\u00072\b\b\u0003\u0010\u0019\u001a\u00020\u00072\b\b\u0003\u0010\u001a\u001a\u00020\u00072\b\b\u0003\u0010\u001b\u001a\u00020\u00032\b\b\u0003\u0010\u001c\u001a\u00020\u00032\b\b\u0003\u0010\u001d\u001a\u00020\u00032\b\b\u0003\u0010\u001e\u001a\u00020\u00032\b\b\u0003\u0010\u001f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010_\u001a\u00020\u0007H\u00d6\u0001J\t\u0010`\u001a\u00020aH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\"R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0011\u0010\u0019\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0011\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0011\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\"R\u0011\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\"\u00a8\u0006b"}, d2 = {"Lcom/example/apistock/data/entities/account/CurrentBalances;", "", "accruedInterest", "", "availableFunds", "availableFundsNonMarginableTrade", "bondValue", "", "buyingPower", "buyingPowerNonMarginableTrade", "cashBalance", "cashReceipts", "dayTradingBuyingPower", "equity", "equityPercentage", "liquidationValue", "longMarginValue", "longMarketValue", "longOptionMarketValue", "maintenanceCall", "maintenanceRequirement", "marginBalance", "moneyMarketFund", "mutualFundValue", "pendingDeposits", "regTCall", "savings", "shortBalance", "shortMarginValue", "shortMarketValue", "shortOptionMarketValue", "sma", "(DDDIDDDIIDDDDDDIDDDIIIIDDDDD)V", "getAccruedInterest", "()D", "getAvailableFunds", "getAvailableFundsNonMarginableTrade", "getBondValue", "()I", "getBuyingPower", "getBuyingPowerNonMarginableTrade", "getCashBalance", "getCashReceipts", "getDayTradingBuyingPower", "getEquity", "getEquityPercentage", "getLiquidationValue", "getLongMarginValue", "getLongMarketValue", "getLongOptionMarketValue", "getMaintenanceCall", "getMaintenanceRequirement", "getMarginBalance", "getMoneyMarketFund", "getMutualFundValue", "getPendingDeposits", "getRegTCall", "getSavings", "getShortBalance", "getShortMarginValue", "getShortMarketValue", "getShortOptionMarketValue", "getSma", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class CurrentBalances {
    private final double accruedInterest = 0.0;
    private final double availableFunds = 0.0;
    private final double availableFundsNonMarginableTrade = 0.0;
    private final int bondValue = 0;
    private final double buyingPower = 0.0;
    private final double buyingPowerNonMarginableTrade = 0.0;
    private final double cashBalance = 0.0;
    private final int cashReceipts = 0;
    private final int dayTradingBuyingPower = 0;
    private final double equity = 0.0;
    private final double equityPercentage = 0.0;
    private final double liquidationValue = 0.0;
    private final double longMarginValue = 0.0;
    private final double longMarketValue = 0.0;
    private final double longOptionMarketValue = 0.0;
    private final int maintenanceCall = 0;
    private final double maintenanceRequirement = 0.0;
    private final double marginBalance = 0.0;
    private final double moneyMarketFund = 0.0;
    private final int mutualFundValue = 0;
    private final int pendingDeposits = 0;
    private final int regTCall = 0;
    private final int savings = 0;
    private final double shortBalance = 0.0;
    private final double shortMarginValue = 0.0;
    private final double shortMarketValue = 0.0;
    private final double shortOptionMarketValue = 0.0;
    private final double sma = 0.0;
    
    public final double getAccruedInterest() {
        return 0.0;
    }
    
    public final double getAvailableFunds() {
        return 0.0;
    }
    
    public final double getAvailableFundsNonMarginableTrade() {
        return 0.0;
    }
    
    public final int getBondValue() {
        return 0;
    }
    
    public final double getBuyingPower() {
        return 0.0;
    }
    
    public final double getBuyingPowerNonMarginableTrade() {
        return 0.0;
    }
    
    public final double getCashBalance() {
        return 0.0;
    }
    
    public final int getCashReceipts() {
        return 0;
    }
    
    public final int getDayTradingBuyingPower() {
        return 0;
    }
    
    public final double getEquity() {
        return 0.0;
    }
    
    public final double getEquityPercentage() {
        return 0.0;
    }
    
    public final double getLiquidationValue() {
        return 0.0;
    }
    
    public final double getLongMarginValue() {
        return 0.0;
    }
    
    public final double getLongMarketValue() {
        return 0.0;
    }
    
    public final double getLongOptionMarketValue() {
        return 0.0;
    }
    
    public final int getMaintenanceCall() {
        return 0;
    }
    
    public final double getMaintenanceRequirement() {
        return 0.0;
    }
    
    public final double getMarginBalance() {
        return 0.0;
    }
    
    public final double getMoneyMarketFund() {
        return 0.0;
    }
    
    public final int getMutualFundValue() {
        return 0;
    }
    
    public final int getPendingDeposits() {
        return 0;
    }
    
    public final int getRegTCall() {
        return 0;
    }
    
    public final int getSavings() {
        return 0;
    }
    
    public final double getShortBalance() {
        return 0.0;
    }
    
    public final double getShortMarginValue() {
        return 0.0;
    }
    
    public final double getShortMarketValue() {
        return 0.0;
    }
    
    public final double getShortOptionMarketValue() {
        return 0.0;
    }
    
    public final double getSma() {
        return 0.0;
    }
    
    public CurrentBalances(@com.squareup.moshi.Json(name = "accruedInterest")
    double accruedInterest, @com.squareup.moshi.Json(name = "availableFunds")
    double availableFunds, @com.squareup.moshi.Json(name = "availableFundsNonMarginableTrade")
    double availableFundsNonMarginableTrade, @com.squareup.moshi.Json(name = "bondValue")
    int bondValue, @com.squareup.moshi.Json(name = "buyingPower")
    double buyingPower, @com.squareup.moshi.Json(name = "buyingPowerNonMarginableTrade")
    double buyingPowerNonMarginableTrade, @com.squareup.moshi.Json(name = "cashBalance")
    double cashBalance, @com.squareup.moshi.Json(name = "cashReceipts")
    int cashReceipts, @com.squareup.moshi.Json(name = "dayTradingBuyingPower")
    int dayTradingBuyingPower, @com.squareup.moshi.Json(name = "equity")
    double equity, @com.squareup.moshi.Json(name = "equityPercentage")
    double equityPercentage, @com.squareup.moshi.Json(name = "liquidationValue")
    double liquidationValue, @com.squareup.moshi.Json(name = "longMarginValue")
    double longMarginValue, @com.squareup.moshi.Json(name = "longMarketValue")
    double longMarketValue, @com.squareup.moshi.Json(name = "longOptionMarketValue")
    double longOptionMarketValue, @com.squareup.moshi.Json(name = "maintenanceCall")
    int maintenanceCall, @com.squareup.moshi.Json(name = "maintenanceRequirement")
    double maintenanceRequirement, @com.squareup.moshi.Json(name = "marginBalance")
    double marginBalance, @com.squareup.moshi.Json(name = "moneyMarketFund")
    double moneyMarketFund, @com.squareup.moshi.Json(name = "mutualFundValue")
    int mutualFundValue, @com.squareup.moshi.Json(name = "pendingDeposits")
    int pendingDeposits, @com.squareup.moshi.Json(name = "regTCall")
    int regTCall, @com.squareup.moshi.Json(name = "savings")
    int savings, @com.squareup.moshi.Json(name = "shortBalance")
    double shortBalance, @com.squareup.moshi.Json(name = "shortMarginValue")
    double shortMarginValue, @com.squareup.moshi.Json(name = "shortMarketValue")
    double shortMarketValue, @com.squareup.moshi.Json(name = "shortOptionMarketValue")
    double shortOptionMarketValue, @com.squareup.moshi.Json(name = "sma")
    double sma) {
        super();
    }
    
    public final double component1() {
        return 0.0;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    public final double component13() {
        return 0.0;
    }
    
    public final double component14() {
        return 0.0;
    }
    
    public final double component15() {
        return 0.0;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final double component17() {
        return 0.0;
    }
    
    public final double component18() {
        return 0.0;
    }
    
    public final double component19() {
        return 0.0;
    }
    
    public final int component20() {
        return 0;
    }
    
    public final int component21() {
        return 0;
    }
    
    public final int component22() {
        return 0;
    }
    
    public final int component23() {
        return 0;
    }
    
    public final double component24() {
        return 0.0;
    }
    
    public final double component25() {
        return 0.0;
    }
    
    public final double component26() {
        return 0.0;
    }
    
    public final double component27() {
        return 0.0;
    }
    
    public final double component28() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.account.CurrentBalances copy(@com.squareup.moshi.Json(name = "accruedInterest")
    double accruedInterest, @com.squareup.moshi.Json(name = "availableFunds")
    double availableFunds, @com.squareup.moshi.Json(name = "availableFundsNonMarginableTrade")
    double availableFundsNonMarginableTrade, @com.squareup.moshi.Json(name = "bondValue")
    int bondValue, @com.squareup.moshi.Json(name = "buyingPower")
    double buyingPower, @com.squareup.moshi.Json(name = "buyingPowerNonMarginableTrade")
    double buyingPowerNonMarginableTrade, @com.squareup.moshi.Json(name = "cashBalance")
    double cashBalance, @com.squareup.moshi.Json(name = "cashReceipts")
    int cashReceipts, @com.squareup.moshi.Json(name = "dayTradingBuyingPower")
    int dayTradingBuyingPower, @com.squareup.moshi.Json(name = "equity")
    double equity, @com.squareup.moshi.Json(name = "equityPercentage")
    double equityPercentage, @com.squareup.moshi.Json(name = "liquidationValue")
    double liquidationValue, @com.squareup.moshi.Json(name = "longMarginValue")
    double longMarginValue, @com.squareup.moshi.Json(name = "longMarketValue")
    double longMarketValue, @com.squareup.moshi.Json(name = "longOptionMarketValue")
    double longOptionMarketValue, @com.squareup.moshi.Json(name = "maintenanceCall")
    int maintenanceCall, @com.squareup.moshi.Json(name = "maintenanceRequirement")
    double maintenanceRequirement, @com.squareup.moshi.Json(name = "marginBalance")
    double marginBalance, @com.squareup.moshi.Json(name = "moneyMarketFund")
    double moneyMarketFund, @com.squareup.moshi.Json(name = "mutualFundValue")
    int mutualFundValue, @com.squareup.moshi.Json(name = "pendingDeposits")
    int pendingDeposits, @com.squareup.moshi.Json(name = "regTCall")
    int regTCall, @com.squareup.moshi.Json(name = "savings")
    int savings, @com.squareup.moshi.Json(name = "shortBalance")
    double shortBalance, @com.squareup.moshi.Json(name = "shortMarginValue")
    double shortMarginValue, @com.squareup.moshi.Json(name = "shortMarketValue")
    double shortMarketValue, @com.squareup.moshi.Json(name = "shortOptionMarketValue")
    double shortOptionMarketValue, @com.squareup.moshi.Json(name = "sma")
    double sma) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}