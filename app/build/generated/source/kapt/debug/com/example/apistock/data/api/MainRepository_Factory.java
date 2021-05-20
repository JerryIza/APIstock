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
public final class MainRepository_Factory implements Factory<MainRepository> {
  private final Provider<StockMarketService> stockMarketServiceProvider;

  public MainRepository_Factory(Provider<StockMarketService> stockMarketServiceProvider) {
    this.stockMarketServiceProvider = stockMarketServiceProvider;
  }

  @Override
  public MainRepository get() {
    return newInstance(stockMarketServiceProvider.get());
  }

  public static MainRepository_Factory create(
      Provider<StockMarketService> stockMarketServiceProvider) {
    return new MainRepository_Factory(stockMarketServiceProvider);
  }

  public static MainRepository newInstance(StockMarketService stockMarketService) {
    return new MainRepository(stockMarketService);
  }
}
