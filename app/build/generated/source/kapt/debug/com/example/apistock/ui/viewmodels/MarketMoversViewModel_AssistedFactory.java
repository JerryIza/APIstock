package com.example.apistock.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.example.apistock.data.api.SymbolRepo;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class MarketMoversViewModel_AssistedFactory implements ViewModelAssistedFactory<MarketMoversViewModel> {
  private final Provider<SymbolRepo> repository;

  @Inject
  MarketMoversViewModel_AssistedFactory(Provider<SymbolRepo> repository) {
    this.repository = repository;
  }

  @Override
  @NonNull
  public MarketMoversViewModel create(SavedStateHandle arg0) {
    return new MarketMoversViewModel(repository.get());
  }
}
