package com.vald3nir.smart_energy.domain.use_cases.sensor

import com.vald3nir.smart_energy.common.core.AppView
import com.vald3nir.smart_energy.data.dto.LoginDTO
import com.vald3nir.smart_energy.data.dto.SensorDTO

interface SensorUseCase {

    suspend fun checkSensorList(
        appView: AppView?,
        onSuccess: (list: List<SensorDTO>) -> Unit,
        onError: (e: Exception?) -> Unit,
    )
}