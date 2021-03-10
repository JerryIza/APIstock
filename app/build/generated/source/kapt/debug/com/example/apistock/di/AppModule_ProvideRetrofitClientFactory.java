package com.example.apistock.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideRetrofitClientFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  public AppModule_ProvideRetrofitClientFactory(Provider<OkHttpClient> okHttpClientProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofitClient(okHttpClientProvider.get());
  }

  public static AppModule_ProvideRetrofitClientFactory create(
      Provider<OkHttpClient> okHttpClientProvider) {
    return new AppModule_ProvideRetrofitClientFactory(okHttpClientProvider);
  }

  public static Retrofit provideRetrofitClient(OkHttpClient okHttpClient) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideRetrofitClient(okHttpClient), "Cannot return null from a non-@Nullable @Provides method");
  }
}
