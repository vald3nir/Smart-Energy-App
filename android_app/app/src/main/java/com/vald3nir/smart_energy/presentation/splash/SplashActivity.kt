package com.vald3nir.smart_energy.presentation.splash

import android.os.Bundle
import com.vald3nir.smart_energy.common.core.BaseActivity
import com.vald3nir.smart_energy.databinding.EmptyLayoutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    private lateinit var binding: EmptyLayoutBinding
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EmptyLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.view = this
        viewModel.loadAppConfig()
    }

}