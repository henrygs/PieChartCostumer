package com.example.graphiccover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class MainActivity : AppCompatActivity() {

    lateinit var pierChat : PieChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pierChat = findViewById(R.id.chart1)
        var textView = findViewById<AppCompatTextView>(R.id.textView)

        pierChat.setMaxAngle(180f)
        pierChat.rotation = -90F
        val value = 90f

        val list: ArrayList<PieEntry> = arrayListOf()
        list.add(PieEntry(value,""))
        list.add(PieEntry(calculateGoalRealAndGoalIdeal(value),""))

        textView.text = "%$value"
        val pieDataSet = PieDataSet(list, "")
        pieDataSet.setColors(resources.getColor(R.color.purple_200), resources.getColor(R.color.purple_500))

        val pieData = PieData(pieDataSet)
        pieData.setDrawValues(true)
        pierChat.description.isEnabled = false
        pierChat.legend.isEnabled = false
        pierChat.setTouchEnabled(false)
        pierChat.data = pieData
        pierChat.setDrawSliceText(false)
        pierChat.getData().setDrawValues(false)
        pierChat.holeRadius = 90f

        pierChat.animateXY(2500, 2500)
    }

    private fun calculateGoalRealAndGoalIdeal(value: Float): Float{
        val total = 100f - value
        return total
    }
}