package com.swu.doran

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ScheduleWritingActivity : AppCompatActivity() {

    var timeString = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_writing)

        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        val time_start_btn = findViewById<Button>(R.id.time_start_btn);
        val time_end_btn = findViewById<Button>(R.id.time_end_btn);

        val time_before1 = findViewById<TextView>(R.id.time_before1);
        val time_before2 = findViewById<TextView>(R.id.time_before2);
        val time_before3 = findViewById<TextView>(R.id.time_before3);
        val time_before4 = findViewById<TextView>(R.id.time_before4);

            backBtn.setOnClickListener{
                val intent = Intent(this, MainDayActivity::class.java)
                startActivity(intent)
            }

            time_start_btn.setOnClickListener{
                val cal = Calendar.getInstance()
                val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}시 ${minute}분"
                time_start_btn.text = timeString
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()
        }

        time_end_btn.setOnClickListener{
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}시 ${minute}분"
                time_end_btn.text = timeString
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()
        }

        time_before1.setOnClickListener{
            if (time_before1 != null) {
                time_before1.isSelected = !time_before1.isSelected; }
        }
        time_before2.setOnClickListener{
            if (time_before2 != null) {
                time_before2.isSelected = !time_before2.isSelected; }
        }
        time_before3.setOnClickListener{
            if (time_before3 != null) {
                time_before3.isSelected = !time_before3.isSelected; }
        }
        time_before4.setOnClickListener{
            if (time_before4 != null) {
                time_before4.isSelected = !time_before4.isSelected; }
        }
    }
}