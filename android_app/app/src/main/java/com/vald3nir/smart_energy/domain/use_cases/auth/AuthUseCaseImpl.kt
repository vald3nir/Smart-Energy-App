package com.vald3nir.smart_energy.domain.use_cases.auth

import com.vald3nir.smart_energy.common.core.AppView
import com.vald3nir.smart_energy.data.dto.LoginDTO
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepository

class AuthUseCaseImpl(private val repository: AuthRepository) : AuthUseCase {

    override suspend fun disconnect() {
        repository.disconnect()
    }

    override suspend fun getUserID(): String? {
        return repository.loadCurrentUser()?.uid
    }

    override suspend fun checkUserLogged(): Boolean {
        return repository.loadCurrentUser() != null
    }

    override suspend fun login(
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

    override suspend fun loadLoginData(
        onSuccess: (loginDTO: LoginDTO?) -> Unit,
        onError: (e: Exception?) -> Unit
    ) {
        repository.loadLoginData(onSuccess, onError)
    }
}