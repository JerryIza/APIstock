package com.example.apistock.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/example/apistock/ui/viewmodels/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/apistock/data/api/MainRepository;", "myPreference", "Lcom/example/apistock/utils/MyPreference;", "(Lcom/example/apistock/data/api/MainRepository;Lcom/example/apistock/utils/MyPreference;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob", "()Lkotlinx/coroutines/CompletableJob;", "setJob", "(Lkotlinx/coroutines/CompletableJob;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tokenLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getTokenLiveData", "()Landroidx/lifecycle/MutableLiveData;", "clearTokenAccess", "", "postTokenAccess", "code", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.CompletableJob job;
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> tokenLiveData = null;
    private final com.example.apistock.data.api.MainRepository repository = null;
    private final com.example.apistock.utils.MyPreference myPreference = null;
    
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
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getTokenLiveData() {
        return null;
    }
    
    public final void clearTokenAccess() {
    }
    
    public final void postTokenAccess(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.example.apistock.data.api.MainRepository repository, @org.jetbrains.annotations.NotNull()
    com.example.apistock.utils.MyPreference myPreference) {
        super();
    }
}