package com.vald3nir.smart_energy.presentation.dashboard

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidplot.pie.Segment
import com.androidplot.pie.SegmentFormatter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vald3nir.smart_energy.common.core.BaseViewModel
import com.vald3nir.smart_energy.common.utils.MAX_VALUE_POWER_CONSUMPTION
import com.vald3nir.smart_energy.common.utils.getColorPowerValue
import com.vald3nir.smart_energy.data.dto.ConsumptionRealTimeDTO
import com.vald3nir.smart_energy.data.dto.ItemChartRealTimeDTO
import com.vald3nir.smart_energy.domain.use_cases.consumption.ConsumptionUseCase
import kotlin.math.abs

class DashboardViewModel(
    private val consumptionUseCase: ConsumptionUseCase,
) : BaseViewModel() {

    private val _consumptionRealTimeDTO = MutableLiveData<ConsumptionRealTimeDTO>()
    val consumptionRealTimeDTO: LiveData<ConsumptionRealTimeDTO> = _consumptionRealTimeDTO

    fun subscriberConsumptionRealTime() {
        consumptionUseCase.subscriberConsumptionRealTime {
            _consumptionRealTimeDTO.postValue(it)
        }
    }

    fun getItemsChartRealTime(currentPower: Double): ArrayList<ItemChartRealTimeDTO> {
        val items = ArrayList<ItemChartRealTimeDTO>()

        val s1 = Segment("", currentPower)
//        val sf1 = SegmentFormatter(getColorPowerValue(currentPower))
        val sf1 = SegmentFormatter(Color.WHITE)
        items.add(ItemChartRealTimeDTO(s1, sf1))

        val s2 = Segment("", abs(MAX_VALUE_POWER_CONSUMPTION - currentPower))
//        val sf2 = SegmentFormatter(Color.WHITE)
        val sf2 = SegmentFormatter(getColorPowerValue(currentPower))
        items.add(ItemChartRealTimeDTO(s2, sf2))

        return items
    }


    fun testFirebase() {
        val db = Firebase.firestore
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    println("${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents -> ${exception.message}")
            }


//        val database = Firebase.database
//        val collection = database
//            .getReference("consumption")
//            .child("a32ab0af-970c-11ec-9779-a463a116a9e2")
//
//        // Read from the database
//        collection.addValueEventListener(object : ValueEventListener {
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val gson = Gson()
//                val dataObj = JSONObject(gson.toJson(snapshot.value))
//
//                val firebaseID = dataObj.keys().next()
//                val consumptions =
//                    (dataObj.get(firebaseID) as JSONArray).toListDeviceConsumptionDTO()
//                print(consumptions)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                print(error)
//            }
//        })
    }

    private fun insertData() {
        val db = Firebase.firestore
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )
        db.collection("users").add(user)
            .addOnSuccessListener { documentReference ->
            }
            .addOnFailureListener { e ->
            }
    }
}