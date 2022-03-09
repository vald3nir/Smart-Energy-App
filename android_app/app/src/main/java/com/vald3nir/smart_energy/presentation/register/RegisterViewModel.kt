package com.vald3nir.smart_energy.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.common.validations.isEmailValid
import com.vald3nir.smart_energy.common.validations.isPasswordValid
import com.vald3nir.smart_energy.data.form.DataUserInputForm
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.register.RegisterUseCase

class RegisterViewModel(
    private val screenNavigation: ScreenNavigation,
    private val registerUseCase: RegisterUseCase,
) : BaseViewModel() {

    private val _registerForm = MutableLiveData<DataUserInputForm>()
    val registerFormState: LiveData<DataUserInputForm> = _registerForm

    fun registerNewUser(email: String, password: String, confirmPassword: String) {
        if (checkRegisterData(email, password, confirmPassword)) {
            view?.showLoading(true)
            registerUseCase.registerNewUser(
                appView = view,
                email = email,
                password = password,
                onSuccess = {
                    view?.showLoading(false)
                    screenNavigation.redirectToHome(view)
                },
                onError = {
                    view?.showLoading(false)
                    view?.showMessage(it?.message)
                })
        }
    }

    fun checkRegisterData(
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {

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

        if (password != confirmPassword) {
            isValid = false
            dataUserInputForm.confirmPasswordError = getString(R.string.passwords_not_equals)
        }

        if (!isValid) {
            _registerForm.value = dataUserInputForm
        }

        return isValid
    }
}