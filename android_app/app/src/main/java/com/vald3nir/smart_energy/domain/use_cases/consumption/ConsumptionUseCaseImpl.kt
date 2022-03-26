package com.vald3nir.smart_energy.domain.use_cases.consumption

import com.vald3nir.smart_energy.data.dto.ConsumptionRealTimeDTO
import com.vald3nir.smart_energy.data.repository.remote.consumption.ConsumptionRepository

class ConsumptionUseCaseImpl(private val repository: ConsumptionRepository) : ConsumptionUseCase {

    override suspend fun subscriberConsumptionRealTime(
        onResponse: (consumptionRealTimeDTO: ConsumptionRealTimeDTO) -> Unit
    ) {
        repository.subscriberConsumptionRealTime(
            topic = "/smart_energy/publish/client/a32ab0af-970c-11ec-9779-a463a116a9e2",
            onResponse = onResponse
        )
    }

}