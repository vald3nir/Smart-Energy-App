package com.vald3nir.smart_energy.common.componets

import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Utils
import com.vald3nir.smart_energy.R

class CustomMarkerView(context: Context?, layoutResource: Int) :
    MarkerView(context, layoutResource) {

    private var tvLabel: TextView? = null

    init {
        tvLabel = findViewById(R.id.tv_label)
    }

    override fun refreshContent(e: Entry, highlight: Highlight?) {
        if (e is CandleEntry) {
            tvLabel?.text = Utils.formatNumber(e.high, 0, true)
        } else {
            tvLabel?.text = Utils.formatNumber(e.y, 0, true)
        }
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}