package com.example.apistock.ui.viewmodels;

import com.example.apistock.data.api.SymbolRepo;
import dagger.internal.Factory;
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
public final class MarketMoversViewModel_AssistedFactory_Factory implements Factory<MarketMoversViewModel_AssistedFactory> {
  private final Provider<SymbolRepo> repositoryProvider;

  public MarketMoversViewModel_AssistedFactory_Factory(Provider<SymbolRepo> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MarketMoversViewModel_AssistedFactory get() {
    return newInstance(repositoryProvider);
  }

  public static MarketMoversViewModel_AssistedFactory_Factory create(
      Provider<SymbolRepo> repositoryProvider) {
    return new MarketMoversViewModel_AssistedFactory_Factory(repositoryProvider);
  }

  public static MarketMoversViewModel_AssistedFactory newInstance(Provider<SymbolRepo> repository) {
    return new MarketMoversViewModel_AssistedFactory(repository);
  }
}
