package com.vald3nir.smart_energy.presentation.splash

import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.common.utils.runDelay
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.config.AppConfigUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel(
    private val screenNavigation: ScreenNavigation,
    private val appConfigUseCase: AppConfigUseCase
) : BaseViewModel() {

    fun loadAppConfig() {

        showLoading(show = true)

        CoroutineScope(Dispatchers.IO).launch {

            withContext(Dispatchers.IO) {

                runDelay(callback = {

                    showLoading(false)
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
                })
            }
        }
    }
}
