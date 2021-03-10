package com.example.apistock.di;

import com.example.apistock.data.api.StockMarketService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideMarketApiServiceFactory implements Factory<StockMarketService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideMarketApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public StockMarketService get() {
    return provideMarketApiService(retrofitProvider.get());
  }

  public static AppModule_ProvideMarketApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideMarketApiServiceFactory(retrofitProvider);
  }

  public static StockMarketService provideMarketApiService(Retrofit retrofit) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideMarketApiService(retrofit), "Cannot return null from a non-@Nullable @Provides method");
  }
}
