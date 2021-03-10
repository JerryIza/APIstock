package com.example.apistock.data.entities.token;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/example/apistock/data/entities/token/TokenAccess;", "", "accessToken", "", "expiresIn", "", "refreshToken", "refreshTokenExpiresIn", "scope", "tokenType", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()I", "getRefreshToken", "getRefreshTokenExpiresIn", "getScope", "getTokenType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class TokenAccess {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accessToken = null;
    private final int expiresIn = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String refreshToken = null;
    private final int refreshTokenExpiresIn = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scope = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tokenType = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccessToken() {
        return null;
    }
    
    public final int getExpiresIn() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRefreshToken() {
        return null;
    }
    
    public final int getRefreshTokenExpiresIn() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScope() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTokenType() {
        return null;
    }
    
    public TokenAccess(@org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "access_token")
    java.lang.String accessToken, @com.squareup.moshi.Json(name = "expires_in")
    int expiresIn, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "refresh_token")
    java.lang.String refreshToken, @com.squareup.moshi.Json(name = "refresh_token_expires_in")
    int refreshTokenExpiresIn, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "scope")
    java.lang.String scope, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "token_type")
    java.lang.String tokenType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.apistock.data.entities.token.TokenAccess copy(@org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "access_token")
    java.lang.String accessToken, @com.squareup.moshi.Json(name = "expires_in")
    int expiresIn, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "refresh_token")
    java.lang.String refreshToken, @com.squareup.moshi.Json(name = "refresh_token_expires_in")
    int refreshTokenExpiresIn, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "scope")
    java.lang.String scope, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "token_type")
    java.lang.String tokenType) {
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