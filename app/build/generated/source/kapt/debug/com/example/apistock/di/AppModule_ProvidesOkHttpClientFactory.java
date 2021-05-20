package com.example.apistock.di;

import com.example.apistock.data.api.RefreshTokenAuthenticator;
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

  private final Provider<RefreshTokenAuthenticator> authenticatorProvider;

  public AppModule_ProvidesOkHttpClientFactory(Provider<Interceptor> interceptorProvider,
      Provider<RefreshTokenAuthenticator> authenticatorProvider) {
    this.interceptorProvider = interceptorProvider;
    this.authenticatorProvider = authenticatorProvider;
  }

  @Override
  public OkHttpClient get() {
    return providesOkHttpClient(interceptorProvider.get(), authenticatorProvider.get());
  }

  public static AppModule_ProvidesOkHttpClientFactory create(
      Provider<Interceptor> interceptorProvider,
      Provider<RefreshTokenAuthenticator> authenticatorProvider) {
    return new AppModule_ProvidesOkHttpClientFactory(interceptorProvider, authenticatorProvider);
  }

  public static OkHttpClient providesOkHttpClient(Interceptor interceptor,
      RefreshTokenAuthenticator authenticator) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.providesOkHttpClient(interceptor, authenticator), "Cannot return null from a non-@Nullable @Provides method");
  }
}
