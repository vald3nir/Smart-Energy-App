package com.vald3nir.smart_energy.presentation.sensor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.data.dto.SensorDTO
import com.vald3nir.smart_energy.data.dto.SensorListDTO
import com.vald3nir.smart_energy.domain.navigation.ScreenNavigation
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import com.vald3nir.smart_energy.domain.use_cases.sensor.SensorUseCase
import kotlinx.coroutines.launch

class SensorManagerViewModel(
    private val screenNavigation: ScreenNavigation,
    private val sensorUseCase: SensorUseCase,
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {

    private val _sensorList = MutableLiveData<SensorDTO>()
    val sensorList: LiveData<SensorDTO> = _sensorList


    fun getSensorList() {

        viewModelScope.launch {
            val userID = authUseCase.getUserID()
            if (userID == null) {
                screenNavigation.redirectToLogin(view)
            } else {
                sensorUseCase.getSensorList(
                    userID = userID,
                    onSuccess = {
                        println(it)
                    },
                    onError = {
                        showMessage(it?.message)
                    }
                )
            }
        }
    }


    fun updateSensorList() {

        val list = listOf(
            SensorDTO(id = "1", alias = "sensor 1", enable = true),
            SensorDTO(id = "2", alias = "sensor 2", enable = true),
            SensorDTO(id = "3", alias = "sensor 3", enable = true),
            SensorDTO(id = "4", alias = "sensor 4", enable = true),
            SensorDTO(id = "5", alias = "sensor 5", enable = true),
        )

        viewModelScope.launch {
            val userID = authUseCase.getUserID()
            if (userID == null) {
                screenNavigation.redirectToLogin(view)
            } else {
                sensorUseCase.updateSensorList(
                    userID = userID,
                    sensorList = SensorListDTO(list),
                    onSuccess = {
                        println()
                    },
                    onError = {
                        showMessage(it?.message)
                    }
                )
            }
        }
    }


    fun addNewDevice(message: String) {

    }


}