package com.vald3nir.smart_energy.data.dto

class LoginDTO(
    val autoLogin: Boolean = false,
    val email: String? = null,
    val password: String? = null,
) : BaseDTO() {
}