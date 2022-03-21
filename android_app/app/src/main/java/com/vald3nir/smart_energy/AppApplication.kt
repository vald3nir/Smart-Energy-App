package com.vald3nir.smart_energy

import android.app.Application
import com.vald3nir.smart_energy.data.repository.local.LocalPreferencesRepository
import com.vald3nir.smart_energy.data.repository.local.LocalPreferencesRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepository
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.config.AppConfigRepository
import com.vald3nir.smart_energy.data.repository.remote.config.AppConfigRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.consumption.ConsumptionRepository
import com.vald3nir.smart_energy.data.repository.remote.consumption.ConsumptionRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.register.RegisterRepository
import com.vald3nir.smart_energy.data.repository.remote.register.RegisterRepositoryImpl
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigationImpl
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.config.AppConfigUseCase
import com.vald3nir.smart_energy.domain.use_cases.config.AppConfigUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.consumption.ConsumptionUseCase
import com.vald3nir.smart_energy.domain.use_cases.consumption.ConsumptionUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.register.RegisterUseCase
import com.vald3nir.smart_energy.domain.use_cases.register.RegisterUseCaseImpl
import com.vald3nir.smart_energy.presentation.dashboard.DashboardViewModel
import com.vald3nir.smart_energy.presentation.login.LoginViewModel
import com.vald3nir.smart_energy.presentation.register.RegisterViewModel
import com.vald3nir.smart_energy.presentation.settings.SettingsViewModel
import com.vald3nir.smart_energy.presentation.splash.SplashViewModel
import io.realm.Realm
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.dsl.module

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@AppApplication)
            modules(getModules())
        }
    }

    private fun getModules(): Module {

        return module {

            // Local repository
            factory<LocalPreferencesRepository> {
                LocalPreferencesRepositoryImpl(
                    context = get()
                )
            }

            // Repositories
            factory<AuthRepository> {
                AuthRepositoryImpl(
                    localPreferences = get()
                )
            }
            factory<ConsumptionRepository> {
                ConsumptionRepositoryImpl()
            }
            factory<RegisterUseCase> {
                RegisterUseCaseImpl(
                    repository = get()
                )
            }
            factory<AppConfigRepository> {
                AppConfigRepositoryImpl()
            }

            // Use cases
            factory<AuthUseCase> {
                AuthUseCaseImpl(
                    repository = get()
                )
            }
            factory<ConsumptionUseCase> {
                ConsumptionUseCaseImpl(
                    repository = get()
                )
            }
            factory<RegisterRepository> {
                RegisterRepositoryImpl()
            }
            factory<AppConfigUseCase> {
                AppConfigUseCaseImpl(
                    repository = get(),
                    screenNavigation = get()
                )
            }

            // Navigation
            factory<ScreenNavigation> { ScreenNavigationImpl() }

            // View models
            viewModel {
                DashboardViewModel(
                    consumptionUseCase = get()
                )
            }
            viewModel {
                SplashViewModel(
                    screenNavigation = get(),
                    authUseCase = get()
                )
            }
            viewModel {
                LoginViewModel(
                    screenNavigation = get(),
                    authUseCase = get(),
                )
            }
            viewModel {
                RegisterViewModel(
                    screenNavigation = get(),
                    registerUseCase = get()
                )
            }
            viewModel {
                SettingsViewModel(
                    appConfigUseCase = get()
                )
            }
        }
    }
}