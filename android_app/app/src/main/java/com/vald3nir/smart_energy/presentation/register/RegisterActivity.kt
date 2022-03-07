package com.vald3nir.smart_energy.presentation.register

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.common.core.BaseActivity
import com.vald3nir.smart_energy.common.extensions.afterTextChanged
import com.vald3nir.smart_energy.databinding.ActivityRegisterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity() {

    private val viewModel: RegisterViewModel by viewModel()
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.view = this
        setupObservers()
    }

    private fun setupObservers() {

        binding.apply {

            toolbar.apply {
                title.text = getString(R.string.register)
                btnBack.setOnClickListener { onBackPressed() }
            }

            btnRegister.setOnClickListener { registerNewUser() }

            edtEmail.afterTextChanged { registerDataChanged() }

            edtPassword.apply { afterTextChanged { registerDataChanged() } }

            edtConfirmPassword.apply {
                afterTextChanged { registerDataChanged() }
                setOnEditorActionListener { _, actionId, _ ->
                    when (actionId) {
                        EditorInfo.IME_ACTION_DONE ->
                            registerNewUser()
                    }
                    false
                }
            }
        }

        viewModel.registerFormState.observe(this@RegisterActivity, Observer {
            val loginState = it ?: return@Observer
            binding.btnRegister.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                binding.edtEmail.error = getString(loginState.usernameError)
            } else {
                binding.edtEmail.error = null
            }

            if (loginState.passwordError != null) {
                binding.edtPassword.error = getString(loginState.passwordError)
            } else {
                binding.edtPassword.error = null
            }

            if (loginState.passwordNotEquals != null) {
                binding.edtConfirmPassword.error = getString(loginState.passwordNotEquals)
            } else {
                binding.edtConfirmPassword.error = null
            }
        })
    }

    private fun registerDataChanged() {
        binding.apply {
            viewModel.registerDataChanged(
                edtEmail.text.toString(),
                edtPassword.text.toString(),
                edtConfirmPassword.text.toString()
            )
        }
    }

    private fun registerNewUser() {
        binding.apply {
            viewModel.registerNewUser(
                email = edtEmail.text.toString(),
                password = edtPassword.text.toString()
            )
        }
    }
}