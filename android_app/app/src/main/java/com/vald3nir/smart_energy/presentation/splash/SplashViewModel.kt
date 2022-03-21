package com.vald3nir.smart_energy.presentation.splash

import androidx.lifecycle.viewModelScope
import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import kotlinx.coroutines.launch

class SplashViewModel(
    private val screenNavigation: ScreenNavigation,
    private val authUseCase: AuthUseCase
) : BaseViewModel() {

    fun loadAppConfig() {
        showLoading(show = true)
        runDelay(callback = {
            showLoading(false)
            viewModelScope.launch {
                if (authUseCase.checkUserLogged()) {
                    screenNavigation.redirectToHome(view)
                } else {
                    screenNavigation.redirectToLogin(view)
                }
            }
        })
    }
}
