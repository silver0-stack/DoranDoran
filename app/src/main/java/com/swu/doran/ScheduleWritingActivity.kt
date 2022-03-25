package com.swu.doran

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
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
        val time_before1 = findViewById<Button>(R.id.time_before1);

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
            time_before1?.isSelected = !time_before1.isSelected

        }
    }
}