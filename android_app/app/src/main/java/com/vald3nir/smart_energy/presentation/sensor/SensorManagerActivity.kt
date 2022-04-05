package com.vald3nir.smart_energy.presentation.sensor

import android.os.Bundle
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import com.vald3nir.smart_energy.common.core.BaseActivity
import com.vald3nir.smart_energy.databinding.ActivityDeviceManagerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SensorManagerActivity : BaseActivity() {

    private val viewModel: SensorManagerViewModel by viewModel()
    private lateinit var binding: ActivityDeviceManagerBinding
    private val barcodeLauncher =
        registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
            if (result.contents != null) {
                viewModel.addNewDevice(result.contents)
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeviceManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.view = this
        setupObservers()
    }

    private fun setupObservers() {

        viewModel.updateSensorList()

        binding.apply {
            btnAddNewSensor.setOnClickListener { readQRCode() }
        }
    }

    private fun readQRCode() {
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.setPrompt("Scan a barcode")
        options.setCameraId(0)
        options.setOrientationLocked(true)
        options.setBeepEnabled(true)
        options.setBarcodeImageEnabled(true)
        barcodeLauncher.launch(options)
    }


}