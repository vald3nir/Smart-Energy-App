package com.vald3nir.smart_energy.data.repository.remote.auth

import android.app.Activity
import com.google.firebase.auth.FirebaseUser
import com.vald3nir.smart_energy.data.dto.LoginDTO

interface AuthRepository {

    suspend fun disconnect()

    suspend fun loadCurrentUser(): FirebaseUser?

    suspend fun login(
        activity: Activity,
        loginDTO: LoginDTO,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    )

    suspend fun loadLoginData(
        onSuccess: (loginDTO: LoginDTO?) -> Unit,
        onError: (e: Exception?) -> Unit,
    )
}