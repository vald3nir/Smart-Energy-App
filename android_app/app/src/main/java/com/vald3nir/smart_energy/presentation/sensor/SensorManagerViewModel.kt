package com.vald3nir.smart_energy.presentation.sensor

import android.widget.Toast
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.sensor.SensorUseCase

class SensorManagerViewModel(
    private val screenNavigation: ScreenNavigation,
    private val sensorUseCase: SensorUseCase
) : BaseViewModel() {

    fun addNewDevice(message: String) {

        Toast.makeText(
            view?.getActivityContext(),
            message,
            Toast.LENGTH_LONG
        ).show()
    }


}