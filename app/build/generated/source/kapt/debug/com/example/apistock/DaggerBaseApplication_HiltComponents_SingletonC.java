package com.example.apistock;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.apistock.data.api.MainRepository;
import com.example.apistock.data.api.RefreshTokenAuthenticator;
import com.example.apistock.data.api.StockMarketService;
import com.example.apistock.di.AppModule;
import com.example.apistock.di.AppModule_ProvideMarketApiServiceFactory;
import com.example.apistock.di.AppModule_ProvideRetrofitClientFactory;
import com.example.apistock.di.AppModule_ProvidesOkHttpClientFactory;
import com.example.apistock.di.AppModule_ProvidesOkHttpInterceptorFactory;
import com.example.apistock.di.AppModule_ProvidesTokenRefreshAuthenticatorFactory;
import com.example.apistock.ui.MainActivity;
import com.example.apistock.ui.viewmodels.LoginViewModel_AssistedFactory;
import com.example.apistock.ui.viewmodels.LoginViewModel_AssistedFactory_Factory;
import com.example.apistock.ui.viewmodels.MarketViewModel_AssistedFactory;
import com.example.apistock.ui.viewmodels.MarketViewModel_AssistedFactory_Factory;
import com.example.apistock.utils.MyPreference;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerBaseApplication_HiltComponents_SingletonC extends BaseApplication_HiltComponents.SingletonC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Object myPreference = new MemoizedSentinel();

  private volatile Object refreshTokenAuthenticator = new MemoizedSentinel();

  private volatile Provider<MyPreference> myPreferenceProvider;

  private DaggerBaseApplication_HiltComponents_SingletonC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private MyPreference myPreference() {
    Object local = myPreference;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = myPreference;
        if (local instanceof MemoizedSentinel) {
          local = new MyPreference(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          myPreference = DoubleCheck.reentrantCheck(myPreference, local);
        }
      }
    }
    return (MyPreference) local;
  }

  private Interceptor interceptor() {
    return AppModule_ProvidesOkHttpInterceptorFactory.providesOkHttpInterceptor(myPreference());
  }

  private RefreshTokenAuthenticator refreshTokenAuthenticator() {
    Object local = refreshTokenAuthenticator;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = refreshTokenAuthenticator;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvidesTokenRefreshAuthenticatorFactory.providesTokenRefreshAuthenticator(myPreference());
          refreshTokenAuthenticator = DoubleCheck.reentrantCheck(refreshTokenAuthenticator, local);
        }
      }
    }
    return (RefreshTokenAuthenticator) local;
  }

  private OkHttpClient okHttpClient() {
    return AppModule_ProvidesOkHttpClientFactory.providesOkHttpClient(interceptor(), refreshTokenAuthenticator());
  }

  private Retrofit retrofit() {
    return AppModule_ProvideRetrofitClientFactory.provideRetrofitClient(okHttpClient());
  }

  private StockMarketService stockMarketService() {
    return AppModule_ProvideMarketApiServiceFactory.provideMarketApiService(retrofit());
  }

  private Provider<MyPreference> myPreferenceProvider() {
    Object local = myPreferenceProvider;
    if (local == null) {
      local = new SwitchingProvider<>(0);
      myPreferenceProvider = (Provider<MyPreference>) local;
    }
    return (Provider<MyPreference>) local;
  }

  @Override
  public void injectBaseApplication(BaseApplication baseApplication) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public BaseApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerBaseApplication_HiltComponents_SingletonC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements BaseApplication_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public BaseApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends BaseApplication_HiltComponents.ActivityRetainedC {
    private volatile Object lifecycle = new MemoizedSentinel();

    private ActivityRetainedCImpl() {

    }

    private Object lifecycle() {
      Object local = lifecycle;
      if (local instanceof MemoizedSentinel) {
        synchronized (local) {
          local = lifecycle;
          if (local instanceof MemoizedSentinel) {
            local = ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();
            lifecycle = DoubleCheck.reentrantCheck(lifecycle, local);
          }
        }
      }
      return (Object) local;
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return (ActivityRetainedLifecycle) lifecycle();
    }

    private final class ActivityCBuilder implements BaseApplication_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public BaseApplication_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends BaseApplication_HiltComponents.ActivityC {
      private final Activity activity;

      private volatile Provider<MainRepository> mainRepositoryProvider;

      private volatile Provider<LoginViewModel_AssistedFactory> loginViewModel_AssistedFactoryProvider;

      private volatile Provider<MarketViewModel_AssistedFactory> marketViewModel_AssistedFactoryProvider;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private MainRepository mainRepository() {
        return new MainRepository(DaggerBaseApplication_HiltComponents_SingletonC.this.stockMarketService());
      }

      private Provider<MainRepository> mainRepositoryProvider() {
        Object local = mainRepositoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(1);
          mainRepositoryProvider = (Provider<MainRepository>) local;
        }
        return (Provider<MainRepository>) local;
      }

      private LoginViewModel_AssistedFactory loginViewModel_AssistedFactory() {
        return LoginViewModel_AssistedFactory_Factory.newInstance(mainRepositoryProvider(), DaggerBaseApplication_HiltComponents_SingletonC.this.myPreferenceProvider());
      }

      private Provider<LoginViewModel_AssistedFactory> loginViewModel_AssistedFactoryProvider() {
        Object local = loginViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          loginViewModel_AssistedFactoryProvider = (Provider<LoginViewModel_AssistedFactory>) local;
        }
        return (Provider<LoginViewModel_AssistedFactory>) local;
      }

      private MarketViewModel_AssistedFactory marketViewModel_AssistedFactory() {
        return MarketViewModel_AssistedFactory_Factory.newInstance(mainRepositoryProvider(), DaggerBaseApplication_HiltComponents_SingletonC.this.myPreferenceProvider());
      }

      private Provider<MarketViewModel_AssistedFactory> marketViewModel_AssistedFactoryProvider() {
        Object local = marketViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(2);
          marketViewModel_AssistedFactoryProvider = (Provider<MarketViewModel_AssistedFactory>) local;
        }
        return (Provider<MarketViewModel_AssistedFactory>) local;
      }

      private Map<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>> mapOfStringAndProviderOfViewModelAssistedFactoryOf(
          ) {
        return MapBuilder.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>newMapBuilder(2).put("com.example.apistock.ui.viewmodels.LoginViewModel", (Provider) loginViewModel_AssistedFactoryProvider()).put("com.example.apistock.ui.viewmodels.MarketViewModel", (Provider) marketViewModel_AssistedFactoryProvider()).build();
      }

      private ViewModelProvider.Factory provideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerBaseApplication_HiltComponents_SingletonC.this.applicationContextModule), mapOfStringAndProviderOfViewModelAssistedFactoryOf());
      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return Collections.<ViewModelProvider.Factory>singleton(provideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private final class FragmentCBuilder implements BaseApplication_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public BaseApplication_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends BaseApplication_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory provideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerBaseApplication_HiltComponents_SingletonC.this.applicationContextModule), ActivityCImpl.this.mapOfStringAndProviderOfViewModelAssistedFactoryOf());
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return Collections.<ViewModelProvider.Factory>singleton(provideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements BaseApplication_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public BaseApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends BaseApplication_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements BaseApplication_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public BaseApplication_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends BaseApplication_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.example.apistock.ui.viewmodels.LoginViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.loginViewModel_AssistedFactory();

            case 1: // com.example.apistock.data.api.MainRepository 
            return (T) ActivityCImpl.this.mainRepository();

            case 2: // com.example.apistock.ui.viewmodels.MarketViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.marketViewModel_AssistedFactory();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements BaseApplication_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends BaseApplication_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }

  private final class SwitchingProvider<T> implements Provider<T> {
    private final int id;

    SwitchingProvider(int id) {
      this.id = id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
      switch (id) {
        case 0: // com.example.apistock.utils.MyPreference 
        return (T) DaggerBaseApplication_HiltComponents_SingletonC.this.myPreference();

        default: throw new AssertionError(id);
      }
    }
  }
}
