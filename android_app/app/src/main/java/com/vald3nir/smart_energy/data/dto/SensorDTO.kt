package com.vald3nir.smart_energy.data.dto

data class SensorDTO(
    val id: String? = null,
    val alias: String? = null,
    val enable: Boolean = false,
) : BaseDTO()