package com.vald3nir.smart_energy.data.repository.remote.sensor

import com.vald3nir.smart_energy.data.dto.SensorListDTO

interface SensorRepository {

    suspend fun updateSensorList(
        userID: String,
        sensorList: SensorListDTO,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    )

    suspend fun getSensorList(
        userID: String,
        onSuccess: (sensorList: SensorListDTO?) -> Unit,
        onError: (e: Exception?) -> Unit,
    )
}