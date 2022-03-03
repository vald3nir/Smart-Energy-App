package com.vald3nir.smart_energy.presentation.dashboard

import android.os.Bundle
import androidx.lifecycle.Observer
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
}