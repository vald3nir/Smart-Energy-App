package com.vald3nir.smart_energy.domain.use_cases.auth

import com.vald3nir.smart_energy.common.core.AppView
import com.vald3nir.smart_energy.data.dto.LoginDTO
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepository

class AuthUseCaseImpl(private val repository: AuthRepository) : AuthUseCase {

    override fun login(
        appView: AppView?,
        loginDTO: LoginDTO,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    ) {
        appView?.apply {
            getActivityContext()?.let { activity ->
                repository.login(
                    activity = activity,
                    loginDTO = loginDTO,
                    onSuccess = onSuccess,
                    onError = onError
                )
            }
        }
    }

    override fun loadLoginData(): LoginDTO? {
        return repository.loadLoginData()
    }
}