package com.vald3nir.smart_energy.data.dto

class LoginDTO(
    val email: String? = null,
    val password: String? = null,
    val rememberLogin: Boolean = false,
    ) : BaseDTO() {
}