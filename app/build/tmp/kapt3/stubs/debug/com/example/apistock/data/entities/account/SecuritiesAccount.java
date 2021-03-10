package com.example.apistock.data.entities.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\t\u0010(\u001a\u00020\u000fH\u00c6\u0003J\t\u0010)\u001a\u00020\u0011H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003Ji\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0003\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\u0011H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001aR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001aR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015\u00a8\u00060"}, d2 = {"Lcom/example/apistock/data/entities/account/SecuritiesAccount;", "", "accountId", "", "currentBalances", "Lcom/example/apistock/data/entities/account/CurrentBalances;", "initialBalances", "Lcom/example/apistock/data/entities/account/InitialBalances;", "isClosingOnlyRestricted", "", "isDayTrader", "positions", "", "Lcom/example/apistock/data/entities/account/Position;", "projectedBalances", "Lcom/example/apistock/data/entities/account/ProjectedBalances;", "roundTrips", "", "type", "(Ljava/lang/String;Lcom/example/apistock/data/entities/account/CurrentBalances;Lcom/example/apistock/data/entities/account/InitialBalances;ZZLjava/util/List;Lcom/example/apistock/data/entities/account/ProjectedBalances;ILjava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getCurrentBalances", "()Lcom/example/apistock/data/entities/account/CurrentBalances;", "getInitialBalances", "()Lcom/example/apistock/data/entities/account/InitialBalances;", "()Z", "getPositions", "()Ljava/util/List;", "getProjectedBalances", "()Lcom/example/apistock/data/entities/account/ProjectedBalances;", "getRoundTrips", "()I", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class SecuritiesAccount {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accountId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.apistock.data.entities.account.CurrentBalances currentBalances = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.apistock.data.entities.account.InitialBalances initialBalances = null;
    private final boolean isClosingOnlyRestricted = false;
    private final boolean isDayTrader = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.apistock.data.entities.account.Position> positions = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.apistock.data.entities.account.ProjectedBalances projectedBalances = null;
    private final int roundTrips = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String type = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccountId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.account.CurrentBalances getCurrentBalances() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.account.InitialBalances getInitialBalances() {
        return null;
    }
    
    public final boolean isClosingOnlyRestricted() {
        return false;
    }
    
    public final boolean isDayTrader() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.apistock.data.entities.account.Position> getPositions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.account.ProjectedBalances getProjectedBalances() {
        return null;
    }
    
    public final int getRoundTrips() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public SecuritiesAccount(@org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "accountId")
    java.lang.String accountId, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "currentBalances")
    com.example.apistock.data.entities.account.CurrentBalances currentBalances, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "initialBalances")
    com.example.apistock.data.entities.account.InitialBalances initialBalances, @com.squareup.moshi.Json(name = "isClosingOnlyRestricted")
    boolean isClosingOnlyRestricted, @com.squareup.moshi.Json(name = "isDayTrader")
    boolean isDayTrader, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "positions")
    java.util.List<com.example.apistock.data.entities.account.Position> positions, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "projectedBalances")
    com.example.apistock.data.entities.account.ProjectedBalances projectedBalances, @com.squareup.moshi.Json(name = "roundTrips")
    int roundTrips, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "type")
    java.lang.String type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.account.CurrentBalances component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.account.InitialBalances component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.apistock.data.entities.account.Position> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.account.ProjectedBalances component7() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.account.SecuritiesAccount copy(@org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "accountId")
    java.lang.String accountId, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "currentBalances")
    com.example.apistock.data.entities.account.CurrentBalances currentBalances, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "initialBalances")
    com.example.apistock.data.entities.account.InitialBalances initialBalances, @com.squareup.moshi.Json(name = "isClosingOnlyRestricted")
    boolean isClosingOnlyRestricted, @com.squareup.moshi.Json(name = "isDayTrader")
    boolean isDayTrader, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "positions")
    java.util.List<com.example.apistock.data.entities.account.Position> positions, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "projectedBalances")
    com.example.apistock.data.entities.account.ProjectedBalances projectedBalances, @com.squareup.moshi.Json(name = "roundTrips")
    int roundTrips, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "type")
    java.lang.String type) {
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