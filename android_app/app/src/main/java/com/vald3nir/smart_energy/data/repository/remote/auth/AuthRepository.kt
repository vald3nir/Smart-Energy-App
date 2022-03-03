package com.vald3nir.smart_energy.data.repository.remote.auth

import android.app.Activity

interface AuthRepository {

    fun login(
        activity: Activity,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (e: Exception?) -> Unit,
    )
}