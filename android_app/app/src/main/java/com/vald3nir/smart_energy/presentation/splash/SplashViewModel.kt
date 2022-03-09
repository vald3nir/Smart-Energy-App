package com.vald3nir.smart_energy.presentation.splash

import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.config.AppConfigUseCase

class SplashViewModel(
    private val screenNavigation: ScreenNavigation,
    private val appConfigUseCase: AppConfigUseCase
) : BaseViewModel() {

    fun loadAppConfig() {

        showLoading(show = true)

        runDelay(callback = {

            runOnMainThread {
                showLoading(false)
                screenNavigation.redirectToLogin(view)
            }


//            runOnBackground {
//
//                appConfigUseCase.loadConfiguration(view,
//
//                    onSuccess = {
//                        runOnMainThread {
//                            showLoading(false)
//                            if (it?.autoLogin == true) {
//                                screenNavigation.redirectToHome(view)
//                            } else {
//                                screenNavigation.redirectToLogin(view)
//                            }
//                        }
//                    },
//                    onError = {
//                        runOnMainThread {
//                            showLoading(false)
//                            view?.showMessage(it?.message)
//                        }
//                    }
//                )
//            }
        })
    }
}
