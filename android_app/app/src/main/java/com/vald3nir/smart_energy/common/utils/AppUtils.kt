package com.vald3nir.smart_energy.common.utils

import java.util.*
import kotlin.concurrent.schedule

suspend fun runDelay(delay: Long = 2000, callback: () -> Unit) {
    Timer("run Delay of $delay", false).schedule(delay) {
        callback.invoke()
    }
}