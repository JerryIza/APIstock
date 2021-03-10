package com.example.apistock.ui.viewmodels;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = MarketMoversViewModel.class
)
public interface MarketMoversViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.example.apistock.ui.viewmodels.MarketMoversViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(MarketMoversViewModel_AssistedFactory factory);
}
