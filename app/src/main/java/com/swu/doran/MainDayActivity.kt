package com.swu.doran

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("WrongViewCast")
class MainDayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_day)

        val scheduleBtn = findViewById<Button>(R.id.scheduleBtn)
        val familyBtn = findViewById<Button>(R.id.familyBtn)
        val gameBtn = findViewById<Button>(R.id.gameBtn)

        scheduleBtn.setOnClickListener{
            val intent = Intent(this, ScheduleWritingActivity::class.java)
            startActivity(intent)
        }

        familyBtn.setOnClickListener{
            val intent = Intent(this, FamilyWriting::class.java)
            startActivity(intent)
        }

        gameBtn.setOnClickListener{
            val intent = Intent(this, GameWriting::class.java)
            startActivity(intent)
        }
    }
}