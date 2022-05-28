package com.vald3nir.smart_energy.common.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.DashPathEffect
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidplot.pie.PieChart
import com.androidplot.pie.Segment
import com.androidplot.pie.SegmentFormatter
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.common.componets.CustomMarkerView
import com.vald3nir.smart_energy.common.componets.DayAxisValueFormatter
import com.vald3nir.smart_energy.common.utils.MAX_VALUE_POWER_CONSUMPTION
import com.vald3nir.smart_energy.common.utils.getColorPowerValue
import com.vald3nir.smart_energy.data.dto.ItemChartRealTimeDTO
import kotlin.math.abs

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun RecyclerView.setup(
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
    layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(
        context,
        LinearLayoutManager.VERTICAL,
        false
    ),
    itemDecoration: RecyclerView.ItemDecoration? = null
) {
    this.adapter = adapter
    this.layoutManager = layoutManager
    if (itemDecoration != null) {
        while (itemDecorationCount > 0) {
            removeItemDecorationAt(0)
        }
        this.addItemDecoration(itemDecoration)
    }
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {

    this.addTextChangedListener(object : TextWatcher {

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}

fun EditText.actionDoneListener(actionDoneListener: () -> Unit) {
    this.setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) actionDoneListener.invoke()
        false
    }
}

fun LineChart.setup(context: Context, values: ArrayList<Entry>) {
    val markerView = CustomMarkerView(context, R.layout.custom_marker_view)
    markerView.chartView = this
    marker = markerView
    legend.form = Legend.LegendForm.NONE
    setBackgroundColor(Color.BLACK)
    description.isEnabled = false
    setTouchEnabled(true)
    setDrawGridBackground(false)
    isDragEnabled = true
    setScaleEnabled(true)
    setPinchZoom(true)
    animateX(1500)
    fillData(values)
}

private fun LineChart.fillData(values: ArrayList<Entry>) {
    val lineDataSet = LineDataSet(values, "")
    lineDataSet.color = Color.YELLOW
    lineDataSet.setCircleColor(Color.YELLOW)
    lineDataSet.valueTextColor = Color.YELLOW
    lineDataSet.fillColor = Color.GREEN
    lineDataSet.lineWidth = 1f
    lineDataSet.circleRadius = 3f
    lineDataSet.setDrawCircleHole(false)
    lineDataSet.formLineWidth = 1f
    lineDataSet.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
    lineDataSet.formSize = 15f
    lineDataSet.valueTextSize = 9f
    lineDataSet.enableDashedHighlightLine(10f, 5f, 0f)
    lineDataSet.setDrawFilled(true)

    val dataSets = ArrayList<ILineDataSet>()
    dataSets.add(lineDataSet)
    data = LineData(dataSets)
}

fun LineChart.appendNewData(value: Float) {


    if (data != null && data.dataSetCount > 0) {
        val lineDataSet: LineDataSet = data.getDataSetByIndex(0) as LineDataSet

        lineDataSet.fillColor = getColorPowerValue(value.toDouble())

        if (lineDataSet.values.isEmpty()) {
            lineDataSet.values.add(Entry(0f, value))

        } else {
            lineDataSet.values.add(Entry(lineDataSet.values.last().x + 1, value))
            if (lineDataSet.values.size >= 100) {
                lineDataSet.values.removeFirst()
            }
        }

        lineDataSet.notifyDataSetChanged()
        data.notifyDataChanged()
        notifyDataSetChanged()
        invalidate()

    } else {
        val values = ArrayList<Entry>()
        values.add(Entry(0f, value))
        fillData(values)
    }
}

fun PieChart.loadData(currentPower: Double) {
    val items = ArrayList<ItemChartRealTimeDTO>()

    val s1 = Segment("", currentPower)
//        val sf1 = SegmentFormatter(getColorPowerValue(currentPower))
    val sf1 = SegmentFormatter(Color.WHITE)
    items.add(ItemChartRealTimeDTO(s1, sf1))

    val s2 = Segment("", abs(MAX_VALUE_POWER_CONSUMPTION - currentPower))
//        val sf2 = SegmentFormatter(Color.WHITE)
    val sf2 = SegmentFormatter(getColorPowerValue(currentPower))
    items.add(ItemChartRealTimeDTO(s2, sf2))

    clear()
    for (item in items) {
        addSegment(item.segment, item.formatter)
    }
    invalidate()

}

fun BarChart.setup() {

    description.isEnabled = false
    legend.form = Legend.LegendForm.NONE

    setOnChartValueSelectedListener(object : OnChartValueSelectedListener {

        override fun onValueSelected(e: Entry?, h: Highlight?) {
            Toast.makeText(context, "${e?.x} - ${e?.y}", Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected() {
        }

    })

    setDrawBarShadow(false)
    setDrawValueAboveBar(true)
    setMaxVisibleValueCount(60)
    setPinchZoom(false)
    setDrawGridBackground(false)

    xAxis.apply {
        textColor = Color.WHITE
        position = XAxis.XAxisPosition.BOTTOM
        setDrawGridLines(false)
        granularity = 1f // only intervals of 1 day
        valueFormatter = DayAxisValueFormatter()
    }

    axisRight.apply {
        setDrawGridLines(false)
        textColor = Color.WHITE
        setLabelCount(8, false)
        spaceTop = 15f
        axisMinimum = 0f
    }


    val start = 1f
    val values = ArrayList<BarEntry>()
    var i = start.toInt()

    while (i < start + 12) {
        values.add(BarEntry(i.toFloat(), (i * 10).toFloat()))
        i++
    }
    xAxis.labelCount = 12

    if (data != null && data.dataSetCount > 0
    ) {
        val set1: BarDataSet = data.getDataSetByIndex(0) as BarDataSet
        set1.values = values
        data.notifyDataChanged()
        notifyDataSetChanged()
        invalidate()

    } else {
        val set1 = BarDataSet(values, "The year 2017")
        set1.setDrawIcons(false)
        val dataSets = ArrayList<IBarDataSet>()
        dataSets.add(set1)
        val barData = BarData(dataSets)
        barData.setValueTextSize(10f)
        barData.barWidth = 0.9f
        data = barData
    }
}