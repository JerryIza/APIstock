package com.example.apistock.data.api;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SymbolRepo_Factory implements Factory<SymbolRepo> {
  private final Provider<StockMarketService> stockMarketServiceProvider;

  public SymbolRepo_Factory(Provider<StockMarketService> stockMarketServiceProvider) {
    this.stockMarketServiceProvider = stockMarketServiceProvider;
  }

  @Override
  public SymbolRepo get() {
    return newInstance(stockMarketServiceProvider.get());
  }

  public static SymbolRepo_Factory create(Provider<StockMarketService> stockMarketServiceProvider) {
    return new SymbolRepo_Factory(stockMarketServiceProvider);
  }

  public static SymbolRepo newInstance(StockMarketService stockMarketService) {
    return new SymbolRepo(stockMarketService);
  }
}
