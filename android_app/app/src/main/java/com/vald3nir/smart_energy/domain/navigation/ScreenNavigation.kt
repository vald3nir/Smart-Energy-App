package com.vald3nir.smart_energy.domain.navigation

import com.vald3nir.smart_energy.common.core.AppView

interface ScreenNavigation {
    fun redirectToLogin(appView: AppView?)
    fun redirectToRegister(appView: AppView?)
    fun redirectToHome(appView: AppView?)
    fun redirectToSettings(appView: AppView?)
    fun redirectToSensorManager(appView: AppView?)
}