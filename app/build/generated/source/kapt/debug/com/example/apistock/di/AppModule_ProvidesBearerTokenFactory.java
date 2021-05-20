package com.example.apistock.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Request;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesBearerTokenFactory implements Factory<Request> {
  private final Provider<Request> $this$providesBearerTokenProvider;

  private final Provider<String> accessTokenProvider;

  public AppModule_ProvidesBearerTokenFactory(Provider<Request> $this$providesBearerTokenProvider,
      Provider<String> accessTokenProvider) {
    this.$this$providesBearerTokenProvider = $this$providesBearerTokenProvider;
    this.accessTokenProvider = accessTokenProvider;
  }

  @Override
  public Request get() {
    return providesBearerToken($this$providesBearerTokenProvider.get(), accessTokenProvider.get());
  }

  public static AppModule_ProvidesBearerTokenFactory create(
      Provider<Request> $this$providesBearerTokenProvider, Provider<String> accessTokenProvider) {
    return new AppModule_ProvidesBearerTokenFactory($this$providesBearerTokenProvider, accessTokenProvider);
  }

  public static Request providesBearerToken(Request $this$providesBearerToken, String accessToken) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.providesBearerToken($this$providesBearerToken, accessToken), "Cannot return null from a non-@Nullable @Provides method");
  }
}
