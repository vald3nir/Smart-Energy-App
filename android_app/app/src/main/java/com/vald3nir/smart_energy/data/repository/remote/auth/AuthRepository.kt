package com.vald3nir.smart_energy.data.repository.remote.auth

import android.app.Activity
import com.google.firebase.auth.FirebaseUser
import com.vald3nir.smart_energy.data.dto.LoginDTO

interface AuthRepository {

    fun loadCurrentUser(): FirebaseUser?

    fun login(
        activity: Activity,
        loginDTO: LoginDTO,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    )

    fun loadLoginData(): LoginDTO?
}