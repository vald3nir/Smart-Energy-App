package com.vald3nir.smart_energy.data.dto

data class DeviceConsumptionDTO(
    val consumption_kwh: Double,
    val date: String,
    val device: String
)