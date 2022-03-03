package com.vald3nir.smart_energy.common.core

import android.app.Activity

interface AppView {

    fun getActivityContext(): Activity?

    fun showMessage(message: String?)

    fun showMessage(message: Int)

    fun showLoading(show: Boolean)
}