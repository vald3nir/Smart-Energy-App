package com.vald3nir.smart_energy.common.extensions

fun Double.toWattsSecond(): String {
    return "${this.toInt()} W/s"
}