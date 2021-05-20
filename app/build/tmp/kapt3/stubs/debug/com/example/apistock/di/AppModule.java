package com.example.apistock.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/example/apistock/di/AppModule;", "", "()V", "provideMarketApiService", "Lcom/example/apistock/data/api/StockMarketService;", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofitClient", "okHttpClient", "Lokhttp3/OkHttpClient;", "providesOkHttpClient", "interceptor", "Lokhttp3/Interceptor;", "authenticator", "Lcom/example/apistock/data/api/RefreshTokenAuthenticator;", "providesOkHttpInterceptor", "myPreference", "Lcom/example/apistock/utils/MyPreference;", "providesTokenRefreshAuthenticator", "tokenRefreshAuthenticator", "Lokhttp3/Authenticator;", "providesBearerToken", "Lokhttp3/Request;", "accessToken", "", "app_debug"})
@dagger.Module()
public final class AppModule {
    public static final com.example.apistock.di.AppModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofitClient(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final okhttp3.Interceptor providesOkHttpInterceptor(@org.jetbrains.annotations.NotNull()
    com.example.apistock.utils.MyPreference myPreference) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final okhttp3.OkHttpClient providesOkHttpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor interceptor, @org.jetbrains.annotations.NotNull()
    com.example.apistock.data.api.RefreshTokenAuthenticator authenticator) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final okhttp3.Request providesBearerToken(@org.jetbrains.annotations.NotNull()
    okhttp3.Request $this$providesBearerToken, @org.jetbrains.annotations.NotNull()
    java.lang.String accessToken) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final okhttp3.Authenticator tokenRefreshAuthenticator() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.apistock.data.api.StockMarketService provideMarketApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.apistock.data.api.RefreshTokenAuthenticator providesTokenRefreshAuthenticator(@org.jetbrains.annotations.NotNull()
    com.example.apistock.utils.MyPreference myPreference) {
        return null;
    }
    
    private AppModule() {
        super();
    }
}