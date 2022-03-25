package com.swu.doran

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class GameWriting : AppCompatActivity() {

    var timeString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_writing)

        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        val date_start_btn= findViewById<Button>(R.id.date_start_btn)
        val date_end_btn = findViewById<Button>(R.id.date_end_btn)

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

    }
}