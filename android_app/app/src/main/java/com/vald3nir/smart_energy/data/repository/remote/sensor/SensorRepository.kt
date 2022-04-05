package com.vald3nir.smart_energy.data.repository.remote.sensor

import com.vald3nir.smart_energy.data.dto.SensorDTO

interface SensorRepository {

    suspend fun updateSensorList(
        userID: String,
        list: List<SensorDTO>,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    )

    suspend fun getSensorList(
        userID: String,
        onSuccess: (list: List<SensorDTO>) -> Unit,
        onError: (e: Exception?) -> Unit,
    )
}