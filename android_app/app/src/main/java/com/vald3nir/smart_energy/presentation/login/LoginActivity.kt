package com.vald3nir.smart_energy.presentation.login

import android.os.Bundle
import androidx.lifecycle.Observer
import com.vald3nir.smart_energy.common.core.BaseActivity
import com.vald3nir.smart_energy.common.extensions.actionDoneListener
import com.vald3nir.smart_energy.common.extensions.afterTextChanged
import com.vald3nir.smart_energy.common.extensions.format
import com.vald3nir.smart_energy.common.extensions.hideKeyboard
import com.vald3nir.smart_energy.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val viewModel: LoginViewModel by viewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.view = this
        setupObservers()
        viewModel.loadLoginData()
    }

    private fun setupObservers() {

        binding.apply {
            btnLogin.setOnClickListener { login() }
            btnRegister.setOnClickListener { register() }
        }

        viewModel.loginDTO.observe(this@LoginActivity, Observer {

            binding.apply {

                edtEmail.setText(it?.email)
                edtPassword.setText(it?.password)
                cbRememberLogin.isChecked = it?.rememberLogin == true

                edtEmail.afterTextChanged { loginDataChanged() }
                edtPassword.apply {
                    afterTextChanged { loginDataChanged() }
                    actionDoneListener { login() }
                }
            }

            hideKeyboard()
        })

        viewModel.loginFormState.observe(this@LoginActivity, Observer {

            val loginState = it ?: return@Observer

            binding.apply {
                edtEmailLayout.error = loginState.emailError
                edtPasswordLayout.error = loginState.passwordError
            }
        })
    }

    private fun ActivityLoginBinding.loginDataChanged() {
        viewModel.checkLoginData(edtEmail.text.format(), edtPassword.text.format())
    }

    private fun ActivityLoginBinding.login() {
        hideKeyboard()
        viewModel.login(
            email = edtEmail.text.format(),
            password = edtPassword.text.format(),
            rememberLogin = cbRememberLogin.isChecked
        )
    }

    private fun ActivityLoginBinding.register() {
        viewModel.register()
    }
}