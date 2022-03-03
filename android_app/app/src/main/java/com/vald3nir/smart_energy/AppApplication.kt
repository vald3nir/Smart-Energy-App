package com.vald3nir.smart_energy

import android.app.Application
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepository
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.consumption.ConsumptionRepository
import com.vald3nir.smart_energy.data.repository.remote.consumption.ConsumptionRepositoryImpl
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.consumption.ConsumptionUseCase
import com.vald3nir.smart_energy.domain.use_cases.consumption.ConsumptionUseCaseImpl
import com.vald3nir.smart_energy.presentation.dashboard.DashboardViewModel
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

            // Repositories
            factory<AuthRepository> { AuthRepositoryImpl() }
            factory<ConsumptionRepository> { ConsumptionRepositoryImpl() }

            // Use cases
            factory<AuthUseCase> { AuthUseCaseImpl(repository = get()) }
            factory<ConsumptionUseCase> { ConsumptionUseCaseImpl(repository = get()) }

            // View models
            viewModel { DashboardViewModel(consumptionUseCase = get()) }

        }
    }
}