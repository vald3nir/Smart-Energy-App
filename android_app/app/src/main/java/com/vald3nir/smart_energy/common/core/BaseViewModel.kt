package com.vald3nir.smart_energy.common.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {
    var view: AppView? = null

    fun showLoading(show: Boolean) {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Main) {
                view?.showLoading(show)
            }
        }
    }
}