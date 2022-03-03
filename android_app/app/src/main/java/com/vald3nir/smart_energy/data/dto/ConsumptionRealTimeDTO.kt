package com.vald3nir.smart_energy.data.dto

import com.google.gson.annotations.SerializedName

data class ConsumptionRealTimeDTO(
    @SerializedName("device_id")
    val deviceId: String,
    val power: Double
)