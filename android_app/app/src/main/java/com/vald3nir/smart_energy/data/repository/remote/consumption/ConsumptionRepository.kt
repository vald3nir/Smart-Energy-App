package com.vald3nir.smart_energy.data.repository.remote.consumption

import com.vald3nir.smart_energy.data.dto.ConsumptionRealTimeDTO

interface ConsumptionRepository {

    suspend fun subscriberConsumptionRealTime(
        topic: String,
        onResponse: (consumptionRealTimeDTO: ConsumptionRealTimeDTO) -> Unit
    )
}