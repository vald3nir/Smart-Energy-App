package com.vald3nir.smart_energy.common.core

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {
    var view: AppView? = null
}