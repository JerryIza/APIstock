package com.example.apistock.data.entities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\bw\b\u0087\b\u0018\u00002\u00020\u0001B\u00fd\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010\'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020(\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0011\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0007\u0012\u0006\u00102\u001a\u00020(\u0012\u0006\u00103\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u00105\u001a\u00020\u0005\u00a2\u0006\u0002\u00106J\t\u0010k\u001a\u00020\u0003H\u00c6\u0003J\t\u0010l\u001a\u00020\u0005H\u00c6\u0003J\t\u0010m\u001a\u00020\u0003H\u00c6\u0003J\t\u0010n\u001a\u00020\u0011H\u00c6\u0003J\t\u0010o\u001a\u00020\u0003H\u00c6\u0003J\t\u0010p\u001a\u00020\u0007H\u00c6\u0003J\t\u0010q\u001a\u00020\u0005H\u00c6\u0003J\t\u0010r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010s\u001a\u00020\u0005H\u00c6\u0003J\t\u0010t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010u\u001a\u00020\u0003H\u00c6\u0003J\t\u0010v\u001a\u00020\u0005H\u00c6\u0003J\t\u0010w\u001a\u00020\u0005H\u00c6\u0003J\t\u0010x\u001a\u00020\u0003H\u00c6\u0003J\t\u0010y\u001a\u00020\u0005H\u00c6\u0003J\t\u0010z\u001a\u00020\u0007H\u00c6\u0003J\t\u0010{\u001a\u00020\u0005H\u00c6\u0003J\t\u0010|\u001a\u00020\u0011H\u00c6\u0003J\t\u0010}\u001a\u00020\u0005H\u00c6\u0003J\t\u0010~\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020(H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020(H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0011H\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020(H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003H\u00c6\u0003J\u00e0\u0003\u0010\u009a\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010\'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020(2\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00112\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020(2\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u0005H\u00c6\u0001J\u0015\u0010\u009b\u0001\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0007H\u00d6\u0001J\n\u0010\u009e\u0001\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00108R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u00108R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00108R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010:R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010<R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00108R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010:R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u00108R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00108R\u0011\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010<R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010:R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00108R\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010:R\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u00108R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u00108R\u0011\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010:R\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u00108R\u0011\u0010\u001b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010:R\u0011\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010<R\u0011\u0010\u001d\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010:R\u0011\u0010\u001e\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010FR\u0011\u0010\u001f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010:R\u0011\u0010 \u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010:R\u0011\u0010!\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010:R\u0011\u0010\"\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010:R\u0011\u0010#\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010:R\u0011\u0010$\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010:R\u0011\u0010%\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010:R\u0011\u0010&\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010:R\u0011\u0010\'\u001a\u00020(\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010)\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010:R\u0011\u0010*\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010<R\u0011\u0010+\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010:R\u0011\u0010,\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010:R\u0011\u0010-\u001a\u00020(\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010]R\u0011\u0010.\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u00108R\u0011\u0010/\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010FR\u0011\u00100\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\be\u00108R\u0011\u00101\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010<R\u0011\u00102\u001a\u00020(\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010]R\u0011\u00103\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u0010:R\u0016\u00104\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010:R\u0016\u00105\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u0010:\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/example/apistock/data/entities/SymbolDetails;", "", "askId", "", "askPrice", "", "askSize", "", "assetMainType", "assetType", "bidId", "bidPrice", "bidSize", "bidTick", "closePrice", "cusip", "delayed", "", "description", "digits", "divAmount", "divDate", "divYield", "exchange", "exchangeName", "highPrice", "lastId", "lastPrice", "lastSize", "lowPrice", "marginable", "mark", "markChangeInDouble", "markPercentChangeInDouble", "nAV", "netChange", "netPercentChangeInDouble", "openPrice", "peRatio", "quoteTimeInLong", "", "regularMarketLastPrice", "regularMarketLastSize", "regularMarketNetChange", "regularMarketPercentChangeInDouble", "regularMarketTradeTimeInLong", "securityStatus", "shortable", "symbol", "totalVolume", "tradeTimeInLong", "volatility", "wkHigh", "wkLow", "(Ljava/lang/String;DILjava/lang/String;Ljava/lang/String;Ljava/lang/String;DILjava/lang/String;DLjava/lang/String;ZLjava/lang/String;IDLjava/lang/String;DLjava/lang/String;Ljava/lang/String;DLjava/lang/String;DIDZDDDDDDDDJDIDDJLjava/lang/String;ZLjava/lang/String;IJDDD)V", "getAskId", "()Ljava/lang/String;", "getAskPrice", "()D", "getAskSize", "()I", "getAssetMainType", "getAssetType", "getBidId", "getBidPrice", "getBidSize", "getBidTick", "getClosePrice", "getCusip", "getDelayed", "()Z", "getDescription", "getDigits", "getDivAmount", "getDivDate", "getDivYield", "getExchange", "getExchangeName", "getHighPrice", "getLastId", "getLastPrice", "getLastSize", "getLowPrice", "getMarginable", "getMark", "getMarkChangeInDouble", "getMarkPercentChangeInDouble", "getNAV", "getNetChange", "getNetPercentChangeInDouble", "getOpenPrice", "getPeRatio", "getQuoteTimeInLong", "()J", "getRegularMarketLastPrice", "getRegularMarketLastSize", "getRegularMarketNetChange", "getRegularMarketPercentChangeInDouble", "getRegularMarketTradeTimeInLong", "getSecurityStatus", "getShortable", "getSymbol", "getTotalVolume", "getTradeTimeInLong", "getVolatility", "getWkHigh", "getWkLow", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class SymbolDetails {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String askId = null;
    private final double askPrice = 0.0;
    private final int askSize = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String assetMainType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String assetType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String bidId = null;
    private final double bidPrice = 0.0;
    private final int bidSize = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String bidTick = null;
    private final double closePrice = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cusip = null;
    private final boolean delayed = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final int digits = 0;
    private final double divAmount = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String divDate = null;
    private final double divYield = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String exchange = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String exchangeName = null;
    private final double highPrice = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lastId = null;
    private final double lastPrice = 0.0;
    private final int lastSize = 0;
    private final double lowPrice = 0.0;
    private final boolean marginable = false;
    private final double mark = 0.0;
    private final double markChangeInDouble = 0.0;
    private final double markPercentChangeInDouble = 0.0;
    private final double nAV = 0.0;
    private final double netChange = 0.0;
    private final double netPercentChangeInDouble = 0.0;
    private final double openPrice = 0.0;
    private final double peRatio = 0.0;
    private final long quoteTimeInLong = 0L;
    private final double regularMarketLastPrice = 0.0;
    private final int regularMarketLastSize = 0;
    private final double regularMarketNetChange = 0.0;
    private final double regularMarketPercentChangeInDouble = 0.0;
    private final long regularMarketTradeTimeInLong = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String securityStatus = null;
    private final boolean shortable = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String symbol = null;
    private final int totalVolume = 0;
    private final long tradeTimeInLong = 0L;
    private final double volatility = 0.0;
    @com.squareup.moshi.Json(name = "52WkHigh")
    private final double wkHigh = 0.0;
    @com.squareup.moshi.Json(name = "52WkLow")
    private final double wkLow = 0.0;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAskId() {
        return null;
    }
    
    public final double getAskPrice() {
        return 0.0;
    }
    
    public final int getAskSize() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAssetMainType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAssetType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBidId() {
        return null;
    }
    
    public final double getBidPrice() {
        return 0.0;
    }
    
    public final int getBidSize() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBidTick() {
        return null;
    }
    
    public final double getClosePrice() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCusip() {
        return null;
    }
    
    public final boolean getDelayed() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final int getDigits() {
        return 0;
    }
    
    public final double getDivAmount() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDivDate() {
        return null;
    }
    
    public final double getDivYield() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExchange() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExchangeName() {
        return null;
    }
    
    public final double getHighPrice() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastId() {
        return null;
    }
    
    public final double getLastPrice() {
        return 0.0;
    }
    
    public final int getLastSize() {
        return 0;
    }
    
    public final double getLowPrice() {
        return 0.0;
    }
    
    public final boolean getMarginable() {
        return false;
    }
    
    public final double getMark() {
        return 0.0;
    }
    
    public final double getMarkChangeInDouble() {
        return 0.0;
    }
    
    public final double getMarkPercentChangeInDouble() {
        return 0.0;
    }
    
    public final double getNAV() {
        return 0.0;
    }
    
    public final double getNetChange() {
        return 0.0;
    }
    
    public final double getNetPercentChangeInDouble() {
        return 0.0;
    }
    
    public final double getOpenPrice() {
        return 0.0;
    }
    
    public final double getPeRatio() {
        return 0.0;
    }
    
    public final long getQuoteTimeInLong() {
        return 0L;
    }
    
    public final double getRegularMarketLastPrice() {
        return 0.0;
    }
    
    public final int getRegularMarketLastSize() {
        return 0;
    }
    
    public final double getRegularMarketNetChange() {
        return 0.0;
    }
    
    public final double getRegularMarketPercentChangeInDouble() {
        return 0.0;
    }
    
    public final long getRegularMarketTradeTimeInLong() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecurityStatus() {
        return null;
    }
    
    public final boolean getShortable() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSymbol() {
        return null;
    }
    
    public final int getTotalVolume() {
        return 0;
    }
    
    public final long getTradeTimeInLong() {
        return 0L;
    }
    
    public final double getVolatility() {
        return 0.0;
    }
    
    public final double getWkHigh() {
        return 0.0;
    }
    
    public final double getWkLow() {
        return 0.0;
    }
    
    public SymbolDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String askId, double askPrice, int askSize, @org.jetbrains.annotations.NotNull()
    java.lang.String assetMainType, @org.jetbrains.annotations.NotNull()
    java.lang.String assetType, @org.jetbrains.annotations.NotNull()
    java.lang.String bidId, double bidPrice, int bidSize, @org.jetbrains.annotations.NotNull()
    java.lang.String bidTick, double closePrice, @org.jetbrains.annotations.NotNull()
    java.lang.String cusip, boolean delayed, @org.jetbrains.annotations.NotNull()
    java.lang.String description, int digits, double divAmount, @org.jetbrains.annotations.NotNull()
    java.lang.String divDate, double divYield, @org.jetbrains.annotations.NotNull()
    java.lang.String exchange, @org.jetbrains.annotations.NotNull()
    java.lang.String exchangeName, double highPrice, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, double lastPrice, int lastSize, double lowPrice, boolean marginable, double mark, double markChangeInDouble, double markPercentChangeInDouble, double nAV, double netChange, double netPercentChangeInDouble, double openPrice, double peRatio, long quoteTimeInLong, double regularMarketLastPrice, int regularMarketLastSize, double regularMarketNetChange, double regularMarketPercentChangeInDouble, long regularMarketTradeTimeInLong, @org.jetbrains.annotations.NotNull()
    java.lang.String securityStatus, boolean shortable, @org.jetbrains.annotations.NotNull()
    java.lang.String symbol, int totalVolume, long tradeTimeInLong, double volatility, double wkHigh, double wkLow) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final double component15() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    public final double component17() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    public final double component20() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    public final double component22() {
        return 0.0;
    }
    
    public final int component23() {
        return 0;
    }
    
    public final double component24() {
        return 0.0;
    }
    
    public final boolean component25() {
        return false;
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
    
    public final double component29() {
        return 0.0;
    }
    
    public final double component30() {
        return 0.0;
    }
    
    public final double component31() {
        return 0.0;
    }
    
    public final double component32() {
        return 0.0;
    }
    
    public final double component33() {
        return 0.0;
    }
    
    public final long component34() {
        return 0L;
    }
    
    public final double component35() {
        return 0.0;
    }
    
    public final int component36() {
        return 0;
    }
    
    public final double component37() {
        return 0.0;
    }
    
    public final double component38() {
        return 0.0;
    }
    
    public final long component39() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component40() {
        return null;
    }
    
    public final boolean component41() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component42() {
        return null;
    }
    
    public final int component43() {
        return 0;
    }
    
    public final long component44() {
        return 0L;
    }
    
    public final double component45() {
        return 0.0;
    }
    
    public final double component46() {
        return 0.0;
    }
    
    public final double component47() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.SymbolDetails copy(@org.jetbrains.annotations.NotNull()
    java.lang.String askId, double askPrice, int askSize, @org.jetbrains.annotations.NotNull()
    java.lang.String assetMainType, @org.jetbrains.annotations.NotNull()
    java.lang.String assetType, @org.jetbrains.annotations.NotNull()
    java.lang.String bidId, double bidPrice, int bidSize, @org.jetbrains.annotations.NotNull()
    java.lang.String bidTick, double closePrice, @org.jetbrains.annotations.NotNull()
    java.lang.String cusip, boolean delayed, @org.jetbrains.annotations.NotNull()
    java.lang.String description, int digits, double divAmount, @org.jetbrains.annotations.NotNull()
    java.lang.String divDate, double divYield, @org.jetbrains.annotations.NotNull()
    java.lang.String exchange, @org.jetbrains.annotations.NotNull()
    java.lang.String exchangeName, double highPrice, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, double lastPrice, int lastSize, double lowPrice, boolean marginable, double mark, double markChangeInDouble, double markPercentChangeInDouble, double nAV, double netChange, double netPercentChangeInDouble, double openPrice, double peRatio, long quoteTimeInLong, double regularMarketLastPrice, int regularMarketLastSize, double regularMarketNetChange, double regularMarketPercentChangeInDouble, long regularMarketTradeTimeInLong, @org.jetbrains.annotations.NotNull()
    java.lang.String securityStatus, boolean shortable, @org.jetbrains.annotations.NotNull()
    java.lang.String symbol, int totalVolume, long tradeTimeInLong, double volatility, double wkHigh, double wkLow) {
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