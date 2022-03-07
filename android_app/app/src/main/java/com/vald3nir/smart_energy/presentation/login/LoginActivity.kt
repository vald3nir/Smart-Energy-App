package com.vald3nir.smart_energy.presentation.login

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import com.vald3nir.smart_energy.common.core.BaseActivity
import com.vald3nir.smart_energy.common.extensions.afterTextChanged
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
    }

    private fun setupObservers() {

        binding.apply {

            btnLogin.apply {
                isEnabled = false
                setOnClickListener { login() }
            }
            btnRegister.setOnClickListener { register() }

            edtEmail.afterTextChanged { loginDataChanged() }

            edtPassword.apply {
                afterTextChanged { loginDataChanged() }
                setOnEditorActionListener { _, actionId, _ ->
                    when (actionId) {
                        EditorInfo.IME_ACTION_DONE ->
                            login()
                    }
                    false
                }
            }
        }

        viewModel.loginFormState.observe(this@LoginActivity, Observer {

            val loginState = it ?: return@Observer

            binding.apply {
                btnLogin.isEnabled = loginState.isDataValid

                edtEmailLayout.error =
                    if (loginState.emailError != null) getString(loginState.emailError) else null

                edtPasswordLayout.error =
                    if (loginState.passwordError != null) getString(loginState.passwordError) else null
            }
        })
    }

    private fun ActivityLoginBinding.loginDataChanged() {
        viewModel.loginDataChanged(
            edtEmail.text.toString(),
            edtPassword.text.toString()
        )
    }

    private fun ActivityLoginBinding.login() {
        viewModel.login(
            email = edtEmail.text.toString(),
            password = edtPassword.text.toString(),
            remember = cbRememberLogin.isChecked
        )
    }

    private fun ActivityLoginBinding.register() {
        viewModel.register()
    }
}