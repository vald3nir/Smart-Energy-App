package com.vald3nir.smart_energy.common.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vald3nir.smart_energy.data.dto.ConsumptionRealTimeDTO
import com.vald3nir.smart_energy.data.dto.DeviceConsumptionDTO
import org.json.JSONArray


fun String.toConsumptionRealTimeDTO(): ConsumptionRealTimeDTO {
    return Gson().fromJson(this, ConsumptionRealTimeDTO::class.java)
}

fun <T> String?.toDTO(classOfT: Class<T>): T {
    return Gson().fromJson(this, classOfT)
}

fun JSONArray.toListDeviceConsumptionDTO(): List<DeviceConsumptionDTO> {
    val type = object : TypeToken<List<DeviceConsumptionDTO?>?>() {}.type
    return Gson().fromJson(this.toString(), type)
}