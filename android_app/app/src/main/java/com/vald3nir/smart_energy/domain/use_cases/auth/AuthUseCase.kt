package com.vald3nir.smart_energy.domain.use_cases.auth

import com.vald3nir.smart_energy.common.core.AppView
import com.vald3nir.smart_energy.data.dto.LoginDTO

interface AuthUseCase {

    fun login(
        appView: AppView?,
        loginDTO: LoginDTO,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    )

    fun loadLoginData(): LoginDTO?
}