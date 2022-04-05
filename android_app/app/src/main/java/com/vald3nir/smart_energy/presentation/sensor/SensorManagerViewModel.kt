package com.vald3nir.smart_energy.presentation.sensor

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.data.dto.SensorDTO
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.sensor.SensorUseCase
import kotlinx.coroutines.launch

class SensorManagerViewModel(
    private val screenNavigation: ScreenNavigation,
    private val sensorUseCase: SensorUseCase
) : BaseViewModel() {

    private val _sensorList = MutableLiveData<SensorDTO>()
    val sensorList: LiveData<SensorDTO> = _sensorList


    fun updateSensorList() {

        val list = listOf(
            SensorDTO(id = "1", alias = "sensor 1", enable = true),
            SensorDTO(id = "2", alias = "sensor 2", enable = true),
            SensorDTO(id = "3", alias = "sensor 3", enable = true),
            SensorDTO(id = "4", alias = "sensor 4", enable = true),
            SensorDTO(id = "5", alias = "sensor 5", enable = true),
        )

        viewModelScope.launch {
            sensorUseCase.updateSensorList(
                userID = "test",
                list = list,
                onSuccess = {
                    println()
                },
                onError = {
                    it?.printStackTrace()
                }
            )
        }
    }


    fun addNewDevice(message: String) {

        Toast.makeText(
            view?.getActivityContext(),
            message,
            Toast.LENGTH_LONG
        ).show()
    }


}