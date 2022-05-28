package com.vald3nir.smart_energy.presentation.sensor

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.common.componets.CustomGenericAdapter
import com.vald3nir.smart_energy.common.core.BaseActivity
import com.vald3nir.smart_energy.common.extensions.setup
import com.vald3nir.smart_energy.data.dto.SensorDTO
import com.vald3nir.smart_energy.databinding.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SensorManagerActivity : BaseActivity() {

    private val viewModel: SensorManagerViewModel by viewModel()
    private lateinit var binding: ActivityDeviceManagerBinding

    private lateinit var adapter: CustomGenericAdapter<SensorDTO, SensorItemListBinding>

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
        setupViews()
        setupObservers()

    }

    private fun setupViews() {

        binding.apply {

            toolbar.apply {
                title.text = getString(R.string.sensor_management)
                btnBack.setOnClickListener {
                    //valdenir checar se ta tudo ok pra ir para o dashboard
                }
            }

            adapter = CustomGenericAdapter(
                SensorItemListBinding::inflate,
                listOf()
            ) { item, itemBinding, _, _ ->
                itemBinding.apply {
                    txvLabel.text = item.alias
                    root.setOnClickListener {

                    }
                }
            }
            rcvSensors.setup(adapter)
        }
    }

    private fun setupObservers() {

        viewModel.sensorList.observe(this@SensorManagerActivity, Observer {
            adapter.update(it.items)
        })

        binding.apply {
            btnAddNewSensor.setOnClickListener { readQRCode() }
        }

        viewModel.getSensorList()
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

    inner class EditSensorSheetDialog(context: Context) :
        BottomSheetDialog(context) {

        init {
            setCancelable(true)
        }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = EditSensorSheetDialogBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.apply {

            }
        }


    }

}