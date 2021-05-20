package com.example.apistock.di;

import com.example.apistock.data.api.RefreshTokenAuthenticator;
import com.example.apistock.utils.MyPreference;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvidesTokenRefreshAuthenticatorFactory implements Factory<RefreshTokenAuthenticator> {
  private final Provider<MyPreference> myPreferenceProvider;

  public AppModule_ProvidesTokenRefreshAuthenticatorFactory(
      Provider<MyPreference> myPreferenceProvider) {
    this.myPreferenceProvider = myPreferenceProvider;
  }

  @Override
  public RefreshTokenAuthenticator get() {
    return providesTokenRefreshAuthenticator(myPreferenceProvider.get());
  }

  public static AppModule_ProvidesTokenRefreshAuthenticatorFactory create(
      Provider<MyPreference> myPreferenceProvider) {
    return new AppModule_ProvidesTokenRefreshAuthenticatorFactory(myPreferenceProvider);
  }

  public static RefreshTokenAuthenticator providesTokenRefreshAuthenticator(
      MyPreference myPreference) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.providesTokenRefreshAuthenticator(myPreference), "Cannot return null from a non-@Nullable @Provides method");
  }
}
