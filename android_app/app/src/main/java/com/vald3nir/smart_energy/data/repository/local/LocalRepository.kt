package com.vald3nir.smart_energy.data.repository.local

import com.vald3nir.smart_energy.data.dto.LoginDTO

interface LocalRepository {
    fun saveLoginPreferences(loginDTO: LoginDTO?)
    fun loadLoginPreferences(): LoginDTO?
}