package com.vald3nir.smart_energy.domain.use_cases.register

import com.vald3nir.smart_energy.common.core.AppView

interface RegisterUseCase {

    fun registerNewUser(
        appView: AppView?,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    )
}