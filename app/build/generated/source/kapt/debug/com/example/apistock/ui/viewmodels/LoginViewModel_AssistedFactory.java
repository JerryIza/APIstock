package com.example.apistock.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.example.apistock.data.api.SymbolRepo;
import com.example.apistock.utils.MyPreference;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class LoginViewModel_AssistedFactory implements ViewModelAssistedFactory<LoginViewModel> {
  private final Provider<SymbolRepo> repository;

  private final Provider<MyPreference> myPreference;

  @Inject
  LoginViewModel_AssistedFactory(Provider<SymbolRepo> repository,
      Provider<MyPreference> myPreference) {
    this.repository = repository;
    this.myPreference = myPreference;
  }

  @Override
  @NonNull
  public LoginViewModel create(SavedStateHandle arg0) {
    return new LoginViewModel(repository.get(), myPreference.get());
  }
}
