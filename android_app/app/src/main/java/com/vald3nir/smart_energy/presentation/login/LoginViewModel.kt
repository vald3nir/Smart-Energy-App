package com.vald3nir.smart_energy.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.common.validations.isEmailValid
import com.vald3nir.smart_energy.common.validations.isPasswordValid
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import com.vald3nir.smart_energy.domain.use_cases.config.AppConfigUseCase

class LoginViewModel(
    private val screenNavigation: ScreenNavigation,
    private val authUseCase: AuthUseCase,
    private val appConfigUseCase: AppConfigUseCase,
) : BaseViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    fun register() {
        screenNavigation.redirectToRegister(view)
    }

    fun login(email: String, password: String, remember: Boolean) {
        showLoading(true)
        authUseCase.login(appView = view, email = email, password = password,
            onSuccess = {
                showLoading(false)
                screenNavigation.redirectToHome(view)
            }, onError = {
                showLoading(false)
                view?.showMessage(it?.message)
            }
        )
    }

    fun loginDataChanged(email: String, password: String) {
        if (!isEmailValid(email)) {
            _loginForm.value = LoginFormState(emailError = R.string.invalid_email)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    data class LoginFormState(
        val emailError: Int? = null,
        val passwordError: Int? = null,
        val isDataValid: Boolean = false
    )
}