package com.vald3nir.smart_energy.domain.use_cases.consumption

import com.vald3nir.smart_energy.data.dto.ConsumptionRealTimeDTO
import com.vald3nir.smart_energy.data.repository.remote.consumption.ConsumptionRepository

class ConsumptionUseCaseImpl(private val repository: ConsumptionRepository) : ConsumptionUseCase {

    override fun subscriberConsumptionRealTime(
        onResponse: (consumptionRealTimeDTO: ConsumptionRealTimeDTO) -> Unit
    ) {
        repository.subscriberConsumptionRealTime(onResponse = onResponse)
    }

}