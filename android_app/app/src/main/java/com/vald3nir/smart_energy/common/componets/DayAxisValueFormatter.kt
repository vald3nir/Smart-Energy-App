package com.vald3nir.smart_energy.common.componets

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ViewPortHandler

class DayAxisValueFormatter : ValueFormatter() {

    private val mMonths = arrayOf(
        "Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"
    )

    override fun getFormattedValue(value: Float): String {
        return mMonths[value.toInt() - 1]
    }

    override fun getFormattedValue(
        value: Float, entry: Entry?, dataSetIndex: Int, viewPortHandler: ViewPortHandler?
    ): String {
        return mMonths[value.toInt() - 1]
    }

    override fun getFormattedValue(value: Float, axis: AxisBase): String {
        return mMonths[value.toInt() - 1]
    }
}