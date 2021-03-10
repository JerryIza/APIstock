package com.example.apistock.ui.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u001e\u0010\u0014\u001a\u00020\n2\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/apistock/ui/adapters/SearchResultsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/apistock/ui/adapters/SearchViewHolder;", "inputs", "Ljava/util/ArrayList;", "Lcom/example/apistock/data/entities/SymbolSearch;", "Lkotlin/collections/ArrayList;", "listener", "Lkotlin/Function1;", "", "", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "app_debug"})
public final class SearchResultsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.apistock.ui.adapters.SearchViewHolder> {
    private final java.util.ArrayList<com.example.apistock.data.entities.SymbolSearch> inputs = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> listener = null;
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.apistock.data.entities.SymbolSearch> inputs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.apistock.ui.adapters.SearchViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.apistock.ui.adapters.SearchViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public SearchResultsAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.apistock.data.entities.SymbolSearch> inputs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> listener) {
        super();
    }
}