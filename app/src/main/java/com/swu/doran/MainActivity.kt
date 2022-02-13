package com.swu.doran

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.swu.doran.mailbox.recieved.member.m_Activity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentDate = findViewById<TextView>(R.id.currentDate)
        val sdf = SimpleDateFormat("yyyy년 MM월")
        currentDate.text = sdf.format(Date())

    }

    fun settingsMenu(view: View) {
        val settingsMenu = findViewById<LinearLayout>(R.id.settingsMenu)
        settingsMenu.visibility = View.VISIBLE
    }

    fun clearMenu(view: View) {
        val settingsMenu = findViewById<LinearLayout>(R.id.settingsMenu)
        settingsMenu.visibility = View.GONE

    }

    fun fullCal(view: View) {
        val intent = Intent(this, MainCalendarActivity::class.java)
        startActivity(intent)
    }

    //가족톡
    fun toFamilyTalk(view: android.view.View) {

    }

    //우체통통
    fun toMailbox(view: android.view.View) {
        startActivity(Intent(this, m_Activity::class.java))
    }
}