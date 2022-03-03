package com.vald3nir.smart_energy.domain.use_cases.consumption

import com.vald3nir.smart_energy.data.dto.ConsumptionRealTimeDTO

interface ConsumptionUseCase {

    fun subscriberConsumptionRealTime(
        onResponse: (consumptionRealTimeDTO: ConsumptionRealTimeDTO) -> Unit
    )

}