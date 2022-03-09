package com.vald3nir.smart_energy.data.repository.local

import com.vald3nir.smart_energy.data.dto.LoginDTO

interface LocalPreferencesRepository {
    fun saveLoginPreferences(loginDTO: LoginDTO?)
    fun loadLoginPreferences(): LoginDTO?
}