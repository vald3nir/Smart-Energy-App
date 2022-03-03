package com.vald3nir.smart_energy.domain.use_cases.auth

import com.vald3nir.smart_energy.common.core.AppView
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepository

class AuthUseCaseImpl(private val repository: AuthRepository) : AuthUseCase {

    override fun login(
        appView: AppView?,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    ) {
        appView?.apply {
            getActivityContext()?.let { activity ->
                repository.login(
                    activity = activity,
                    email = email,
                    password = password,
                    onSuccess = onSuccess,
                    onError = onError
                )
            }
        }
    }
}