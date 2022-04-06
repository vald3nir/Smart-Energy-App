package com.vald3nir.smart_energy.data.dto

class SensorListDTO(
    private val items: List<SensorDTO> = listOf()
) {

    fun toHashMap(): MutableMap<String, Any> {
        val data: MutableMap<String, Any> = HashMap()
        data["sensors"] = items
        return data
    }

}

fun MutableMap<String, Any>.toSensorListDTO(): SensorListDTO {
    val items: List<SensorDTO> = if (this["sensors"] is List<*>) {
        this["sensors"] as List<SensorDTO>
    } else {
        listOf()
    }
    return SensorListDTO(items)
}