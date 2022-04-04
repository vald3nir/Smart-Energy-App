package com.vald3nir.smart_energy.domain.navigation

import android.content.Intent
import com.vald3nir.smart_energy.common.core.AppView
import com.vald3nir.smart_energy.common.extensions.hideKeyboard
import com.vald3nir.smart_energy.presentation.dashboard.DashboardActivity
import com.vald3nir.smart_energy.presentation.sensor.SensorManagerActivity
import com.vald3nir.smart_energy.presentation.login.LoginActivity
import com.vald3nir.smart_energy.presentation.register.RegisterActivity
import com.vald3nir.smart_energy.presentation.settings.SettingsActivity

class ScreenNavigationImpl : ScreenNavigation {

    private fun <T> openActivity(view: AppView?, classJava: Class<T>, newStack: Boolean = false) {
        view?.getActivityContext()?.apply {
            hideKeyboard()
            val newIntent = Intent(this, classJava)
            if (newStack) {
                newIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(newIntent)
        }
    }

    override fun redirectToLogin(appView: AppView?) {
        openActivity(appView, LoginActivity::class.java, newStack = true)
    }

    override fun redirectToRegister(appView: AppView?) {
        openActivity(appView, RegisterActivity::class.java)
    }

    override fun redirectToHome(appView: AppView?) {
        openActivity(appView, DashboardActivity::class.java, newStack = true)
    }

    override fun redirectToSettings(appView: AppView?) {
        openActivity(appView, SettingsActivity::class.java)
    }

    override fun redirectToSensorManager(appView: AppView?) {
        openActivity(appView, SensorManagerActivity::class.java)
    }
}