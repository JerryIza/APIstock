package com.example.apistock.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.Authenticator;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_TokenRefreshAuthenticatorFactory implements Factory<Authenticator> {
  @Override
  public Authenticator get() {
    return tokenRefreshAuthenticator();
  }

  public static AppModule_TokenRefreshAuthenticatorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Authenticator tokenRefreshAuthenticator() {
    return Preconditions.checkNotNull(AppModule.INSTANCE.tokenRefreshAuthenticator(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final AppModule_TokenRefreshAuthenticatorFactory INSTANCE = new AppModule_TokenRefreshAuthenticatorFactory();
  }
}
