package com.vald3nir.smart_energy.data.repository.remote.config

import com.vald3nir.smart_energy.data.dto.AppConfigDTO

class AppConfigRepositoryImpl : AppConfigRepository {

    override fun loadConfiguration(
        userId: String,
        onSuccess: (AppConfigDTO?) -> Unit,
        onError: (e: Exception?) -> Unit
    ) {
//        val reference = Firebase.database.reference
//        reference.child("users").child(userId).get().addOnSuccessListener {
//            val snap = (it as DataSnapshot)
//            val appConfigDTO = snap.getValue(AppConfigDTO::class.java)
//            onSuccess.invoke(appConfigDTO)
//        }.addOnFailureListener {
//            onError.invoke(it)
//        }
    }

    override fun updateConfiguration(
        userId: String,
        appConfigDTO: AppConfigDTO,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit
    ) {
//        val reference = Firebase.database.reference
//        reference.child("users").child(userId).setValue(appConfigDTO)
//            .addOnSuccessListener { onSuccess.invoke() }
//            .addOnFailureListener { onError.invoke(it) }
    }
}