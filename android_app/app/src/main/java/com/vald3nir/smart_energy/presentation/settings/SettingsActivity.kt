package com.vald3nir.smart_energy.presentation.settings

import android.os.Bundle
import androidx.lifecycle.Observer
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.common.core.BaseActivity
import com.vald3nir.smart_energy.databinding.ActivitySettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsActivity : BaseActivity() {

    private val viewModel: SettingsViewModel by viewModel()
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.view = this
        setupObservers()
        viewModel.loadConfiguration()
    }

    private fun setupObservers() {

        binding.apply {
            toolbar.apply {
                title.text = getString(R.string.configuration)
                btnBack.setOnClickListener { onBackPressed() }
                btnSave.setOnClickListener { updateConfiguration() }
            }
        }

        viewModel.appConfigForm.observe(this@SettingsActivity, Observer {
            val appConfigForm = it ?: return@Observer

            binding.apply {
//                swAutoLogin.isChecked = appConfigForm.autoLogin
//                edtIpServer.setText(appConfigForm.ipServer)
            }
        })
    }

    private fun updateConfiguration() {
//        binding.apply {
//            viewModel.updateConfiguration(
//                autoLogin = swAutoLogin.isChecked,
//                ipServer = edtIpServer.text.toString()
//            )
//
//        }
    }
}