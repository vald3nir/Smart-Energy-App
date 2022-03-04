package com.vald3nir.smart_energy.domain.use_cases.register

import com.vald3nir.smart_energy.common.core.AppView
import com.vald3nir.smart_energy.data.repository.remote.register.RegisterRepository

class RegisterUseCaseImpl(private val repository: RegisterRepository) : RegisterUseCase {

    override fun registerNewUser(
        appView: AppView?,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit
    ) {
        appView?.getActivityContext()?.let { activity ->
            repository.registerNewUser(
                activity = activity,
                email = email,
                password = password,
                onSuccess = onSuccess,
                onError = onError
            )
        }

    }
}