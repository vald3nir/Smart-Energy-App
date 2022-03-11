package com.vald3nir.smart_energy.presentation.dashboard

import android.os.Bundle
import android.widget.Button
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.common.core.BaseActivity
import com.vald3nir.smart_energy.common.extensions.appendNewData
import com.vald3nir.smart_energy.common.extensions.loadData
import com.vald3nir.smart_energy.common.extensions.setup
import com.vald3nir.smart_energy.common.extensions.toWattsSecond
import com.vald3nir.smart_energy.common.utils.getColorPowerValue
import com.vald3nir.smart_energy.common.utils.getPowerStatus
import com.vald3nir.smart_energy.databinding.ActivityDashboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DashboardActivity : BaseActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val viewModel: DashboardViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.view = this
        initViews()
        setupObservers()
    }

    private fun initViews() {
        binding.apply {

            toolbar.apply {
                btnBack.isVisible = false
                title.setText(R.string.app_name)
                btnConfig.isVisible = true
                btnConfig.setOnClickListener{
                    openMenu()
                }
            }

            chartRealTime.setup(this@DashboardActivity, arrayListOf())
            chartConsumptionYearly.setup()
        }
        viewModel.testFirebase()
    }


    private fun setupObservers() {
        viewModel.subscriberConsumptionRealTime()
        viewModel.consumptionRealTimeDTO.observe(this@DashboardActivity, Observer {
            val consumptionRealTimeDTO = it ?: return@Observer
            updateRealTime(consumptionRealTimeDTO.power)
        })
    }


    private fun updateRealTime(currentPower: Double) {
        binding.apply {
            txvConsumptionStatusValue.apply {
                text = getPowerStatus(context, currentPower)
                setTextColor(getColorPowerValue(currentPower))
            }
            txvConsumptionRealtimeValue.text = currentPower.toWattsSecond()
            pieChart.loadData(currentPower)
            chartRealTime.appendNewData(currentPower.toFloat())
        }
    }

    private fun openMenu(){
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.custom_sheet_dialog, null)

        // on below line we are creating a variable for our button
        // which we are using to dismiss our dialog.
//        val btnClose = view.findViewById<Button>(R.id.idBtnDismiss)
//
//        // on below line we are adding on click listener
//        // for our dismissing the dialog button.
//        btnClose.setOnClickListener {
//            // on below line we are calling a dismiss
//            // method to close our dialog.
//            dialog.dismiss()
//        }
        // below line is use to set cancelable to avoid
        // closing of dialog box when clicking on the screen.
        dialog.setCancelable(true)

        // on below line we are setting
        // content view to our view.
        dialog.setContentView(view)

        // on below line we are calling
        // a show method to display a dialog.
        dialog.show()
    }
}