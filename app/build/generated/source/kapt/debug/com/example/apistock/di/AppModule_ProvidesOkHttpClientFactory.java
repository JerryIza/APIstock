package com.example.apistock.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<Interceptor> interceptorProvider;

  public AppModule_ProvidesOkHttpClientFactory(Provider<Interceptor> interceptorProvider) {
    this.interceptorProvider = interceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return providesOkHttpClient(interceptorProvider.get());
  }

  public static AppModule_ProvidesOkHttpClientFactory create(
      Provider<Interceptor> interceptorProvider) {
    return new AppModule_ProvidesOkHttpClientFactory(interceptorProvider);
  }

  public static OkHttpClient providesOkHttpClient(Interceptor interceptor) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.providesOkHttpClient(interceptor), "Cannot return null from a non-@Nullable @Provides method");
  }
}
