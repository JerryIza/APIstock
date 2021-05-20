package com.example.apistock.data.api;

import com.example.apistock.utils.MyPreference;
import dagger.internal.Factory;
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
public final class RefreshTokenAuthenticator_Factory implements Factory<RefreshTokenAuthenticator> {
  private final Provider<MyPreference> myPreferenceProvider;

  private final Provider<Lazy<? extends StockMarketService>> fooProvider;

  public RefreshTokenAuthenticator_Factory(Provider<MyPreference> myPreferenceProvider,
      Provider<Lazy<? extends StockMarketService>> fooProvider) {
    this.myPreferenceProvider = myPreferenceProvider;
    this.fooProvider = fooProvider;
  }

  @Override
  public RefreshTokenAuthenticator get() {
    RefreshTokenAuthenticator instance = newInstance(myPreferenceProvider.get());
    RefreshTokenAuthenticator_MembersInjector.injectGetLazy(instance, fooProvider.get());
    return instance;
  }

  public static RefreshTokenAuthenticator_Factory create(
      Provider<MyPreference> myPreferenceProvider,
      Provider<Lazy<? extends StockMarketService>> fooProvider) {
    return new RefreshTokenAuthenticator_Factory(myPreferenceProvider, fooProvider);
  }

  public static RefreshTokenAuthenticator newInstance(MyPreference myPreference) {
    return new RefreshTokenAuthenticator(myPreference);
  }
}
