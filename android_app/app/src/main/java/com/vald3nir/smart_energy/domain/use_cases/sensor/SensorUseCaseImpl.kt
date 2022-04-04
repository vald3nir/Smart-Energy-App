package com.vald3nir.smart_energy.domain.use_cases.sensor

import com.vald3nir.smart_energy.common.core.AppView
import com.vald3nir.smart_energy.data.dto.SensorDTO
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepository

class SensorUseCaseImpl(private val repository: AuthRepository) : SensorUseCase {

    override suspend fun checkSensorList(
        appView: AppView?,
        onSuccess: (list: List<SensorDTO>) -> Unit,
        onError: (e: Exception?) -> Unit
    ) {

    }


}