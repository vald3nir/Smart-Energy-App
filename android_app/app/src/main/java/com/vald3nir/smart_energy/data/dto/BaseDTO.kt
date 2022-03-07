package com.vald3nir.smart_energy.data.dto

import com.google.gson.Gson

open class BaseDTO {

    fun toJson(): String? {
        return Gson().toJson(this)
    }

    fun <T> fromJson(json: String?, classOfT: Class<T>): T {
        return Gson().fromJson(json, classOfT)
    }

}