package com.example.apistock.di;

import com.example.apistock.utils.MyPreference;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesOkHttpInterceptorFactory implements Factory<Interceptor> {
  private final Provider<MyPreference> myPreferenceProvider;

  public AppModule_ProvidesOkHttpInterceptorFactory(Provider<MyPreference> myPreferenceProvider) {
    this.myPreferenceProvider = myPreferenceProvider;
  }

  @Override
  public Interceptor get() {
    return providesOkHttpInterceptor(myPreferenceProvider.get());
  }

  public static AppModule_ProvidesOkHttpInterceptorFactory create(
      Provider<MyPreference> myPreferenceProvider) {
    return new AppModule_ProvidesOkHttpInterceptorFactory(myPreferenceProvider);
  }

  public static Interceptor providesOkHttpInterceptor(MyPreference myPreference) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.providesOkHttpInterceptor(myPreference), "Cannot return null from a non-@Nullable @Provides method");
  }
}
