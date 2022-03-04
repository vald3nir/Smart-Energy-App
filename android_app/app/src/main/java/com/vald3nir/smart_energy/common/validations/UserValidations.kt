package com.vald3nir.smart_energy.common.validations

import android.util.Patterns

fun isEmailValid(username: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(username).matches()
}

fun isPasswordValid(password: String): Boolean {
    return password.length > 6
}