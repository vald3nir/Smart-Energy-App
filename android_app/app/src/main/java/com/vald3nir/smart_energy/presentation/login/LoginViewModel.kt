package com.vald3nir.smart_energy.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.common.validations.isEmailValid
import com.vald3nir.smart_energy.common.validations.isPasswordValid
import com.vald3nir.smart_energy.data.dto.LoginDTO
import com.vald3nir.smart_energy.data.form.DataUserInputForm
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase

class LoginViewModel(
    private val screenNavigation: ScreenNavigation,
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {

    private val _loginForm = MutableLiveData<DataUserInputForm>()
    val loginFormState: LiveData<DataUserInputForm> = _loginForm

    private val _loginDTO = MutableLiveData<LoginDTO?>()
    val loginDTO: LiveData<LoginDTO?> = _loginDTO

    fun loadLoginData() {
        runOnBackground {
            val loginDTO = authUseCase.loadLoginData()
            runOnMainThread {
                _loginDTO.postValue(loginDTO)
            }
        }
    }


    fun register() {
        screenNavigation.redirectToRegister(view)
    }

    fun login(email: String, password: String, rememberLogin: Boolean) {

        if (checkLoginData(email, password)) {

            showLoading(true)

            val loginDTO = LoginDTO(email, password, rememberLogin)

            authUseCase.login(appView = view, loginDTO = loginDTO,
                onSuccess = {
                    showLoading(false)
                    screenNavigation.redirectToHome(view)
                },
                onError = {
                    showLoading(false)
                    view?.showMessage(it?.message)
                }
            )
        }
    }

    fun checkLoginData(email: String, password: String): Boolean {
        var isValid = true
        val dataUserInputForm = DataUserInputForm()

        if (!isEmailValid(email)) {
            isValid = false
            dataUserInputForm.emailError = getString(R.string.invalid_email)
        }

        if (!isPasswordValid(password)) {
            isValid = false
            dataUserInputForm.passwordError = getString(R.string.invalid_password)
        }

        if (!isValid) {
            _loginForm.value = dataUserInputForm
        }

        return isValid
    }
}