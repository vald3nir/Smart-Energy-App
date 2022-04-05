package com.vald3nir.smart_energy.domain.use_cases.sensor

import com.vald3nir.smart_energy.data.dto.SensorDTO
import com.vald3nir.smart_energy.data.repository.remote.sensor.SensorRepository

class SensorUseCaseImpl(private val repository: SensorRepository) : SensorUseCase {

    override suspend fun updateSensorList(
        userID: String,
        list: List<SensorDTO>,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit
    ) {
        repository.updateSensorList(userID, list, onSuccess, onError)
    }

    override suspend fun getSensorList(
        userID: String,
        onSuccess: (list: List<SensorDTO>) -> Unit,
        onError: (e: Exception?) -> Unit
    ) {
        repository.getSensorList(userID, onSuccess, onError)
    }
}