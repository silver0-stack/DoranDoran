package com.swu.doran

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.*

class GameWriting : AppCompatActivity() {

    var timeString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_writing)

        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        val date_start_btn= findViewById<Button>(R.id.date_start_btn)
        val date_end_btn = findViewById<Button>(R.id.date_end_btn)

        val day1Btn = findViewById<TextView>(R.id.day1_btn)
        val day2Btn = findViewById<TextView>(R.id.day2_btn)
        val day3Btn = findViewById<TextView>(R.id.day3_btn)
        val day4Btn = findViewById<TextView>(R.id.day4_btn)


        backBtn.setOnClickListener{
            val intent = Intent(this, MainDayActivity::class.java)
            startActivity(intent)
        }


        date_start_btn.setOnClickListener{
            val cal = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                timeString = "${year}년 ${month+1}월 ${dayOfMonth}일"
                date_start_btn.text = timeString
            }
            DatePickerDialog(this, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        date_end_btn.setOnClickListener{
            val cal = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                timeString = "${year}년 ${month+1}월 ${dayOfMonth}일"
                date_end_btn.text = timeString
            }
            DatePickerDialog(this, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }


        day1Btn.setOnClickListener{
            if (day1Btn != null) {
                day1Btn.isSelected = !day1Btn.isSelected;
                //day1Btn.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.white))
            }

        }
        day2Btn.setOnClickListener{
            if (day2Btn != null) {
                day2Btn.isSelected = !day2Btn.isSelected; }
        }
        day3Btn.setOnClickListener{
            if (day3Btn != null) {
                day3Btn.isSelected = !day3Btn.isSelected; }
        }
        day4Btn.setOnClickListener{
            if (day4Btn != null) {
                day4Btn.isSelected = !day4Btn.isSelected; }
        }

    }
}