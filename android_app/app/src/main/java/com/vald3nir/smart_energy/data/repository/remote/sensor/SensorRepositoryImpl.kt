package com.vald3nir.smart_energy.data.repository.remote.sensor

import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.vald3nir.smart_energy.data.dto.SensorDTO


class SensorRepositoryImpl : SensorRepository {

    override suspend fun updateSensorList(
        userID: String,
        list: List<SensorDTO>,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit
    ) {

        val data: MutableMap<String, Any> = HashMap()
        data["sensors"] = list //Gson().toJson(list)

        FirebaseFirestore.getInstance()
            .collection(userID)
            .document("sensor_list")
            .collection("users")
//            .document("sensors")
//            .collection("sensors")
            .add(data)
            .addOnSuccessListener { documentReference ->
                println(documentReference.id)
                onSuccess.invoke()
            }
            .addOnFailureListener {
                onError.invoke(it)
            }

    }

    override suspend fun getSensorList(
        userID: String,
        onSuccess: (list: List<SensorDTO>) -> Unit,
        onError: (e: Exception?) -> Unit
    ) {

    }
}