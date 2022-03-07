package com.vald3nir.smart_energy.data.repository.local

import android.annotation.SuppressLint
import android.content.Context
import com.vald3nir.smart_energy.common.extensions.toDTO
import com.vald3nir.smart_energy.data.dto.LoginDTO

class LocalRepositoryImpl(private val context: Context) : LocalRepository {

    @SuppressLint("CommitPrefEdits")
    override fun saveLoginPreferences(loginDTO: LoginDTO?) {
        val sharedPref = context.getSharedPreferences("", Context.MODE_PRIVATE).edit()
        sharedPref.putString("", loginDTO?.toJson())
    }

    override fun loadLoginPreferences(): LoginDTO? {
        val sharedPref = context.getSharedPreferences("", Context.MODE_PRIVATE)
        val json: String? = sharedPref.getString("", "")
        return json?.toDTO(LoginDTO::class.java)
    }
}