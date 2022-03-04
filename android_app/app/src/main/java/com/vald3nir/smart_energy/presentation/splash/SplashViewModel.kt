package com.vald3nir.smart_energy.presentation.splash

import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.config.AppConfigUseCase
import java.util.*
import kotlin.concurrent.schedule

class SplashViewModel(
    private val screenNavigation: ScreenNavigation,
    private val appConfigUseCase: AppConfigUseCase
) : BaseViewModel() {

    fun loadAppConfig() {
        view?.showLoading(true)
        Timer("check app configuration", false).schedule(1500) {
            appConfigUseCase.loadConfiguration(view,
                onSuccess = {
                    if (it?.autoLogin == true) {
                        screenNavigation.redirectToHome(view)
                    } else {
                        screenNavigation.redirectToLogin(view)
                    }
                },
                onError = {
                    view?.showMessage(it?.message)
                }
            )
        }
    }
}
