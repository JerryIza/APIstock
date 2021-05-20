package com.example.apistock.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.example.apistock.data.api.MainRepository;
import com.example.apistock.utils.MyPreference;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class MarketViewModel_AssistedFactory implements ViewModelAssistedFactory<MarketViewModel> {
  private final Provider<MainRepository> repository;

  private final Provider<MyPreference> myPreference;

  @Inject
  MarketViewModel_AssistedFactory(Provider<MainRepository> repository,
      Provider<MyPreference> myPreference) {
    this.repository = repository;
    this.myPreference = myPreference;
  }

  @Override
  @NonNull
  public MarketViewModel create(SavedStateHandle arg0) {
    return new MarketViewModel(repository.get(), myPreference.get());
  }
}
