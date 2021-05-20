package com.example.apistock.data.api;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import kotlin.Lazy;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RefreshTokenAuthenticator_MembersInjector implements MembersInjector<RefreshTokenAuthenticator> {
  private final Provider<Lazy<? extends StockMarketService>> fooProvider;

  public RefreshTokenAuthenticator_MembersInjector(
      Provider<Lazy<? extends StockMarketService>> fooProvider) {
    this.fooProvider = fooProvider;
  }

  public static MembersInjector<RefreshTokenAuthenticator> create(
      Provider<Lazy<? extends StockMarketService>> fooProvider) {
    return new RefreshTokenAuthenticator_MembersInjector(fooProvider);
  }

  @Override
  public void injectMembers(RefreshTokenAuthenticator instance) {
    injectGetLazy(instance, fooProvider.get());
  }

  public static void injectGetLazy(RefreshTokenAuthenticator instance,
      Lazy<? extends StockMarketService> foo) {
    instance.getLazy(foo);
  }
}
