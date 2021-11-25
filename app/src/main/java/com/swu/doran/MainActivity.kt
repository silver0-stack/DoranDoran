package com.swu.doran

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

//test
class MainActivity : AppCompatActivity() {

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var settings=findViewById<ImageView>(R.id.settings)
        val currentDate=findViewById<TextView>(R.id.currentDate)
        val sdf=SimpleDateFormat("yyyy년 MM월")
        currentDate.text = sdf.format(Date())

   }

    fun settingsMenu(view: View) {
        val settingsMenu=findViewById<LinearLayout>(R.id.settingsMenu)
        settingsMenu.visibility= View.VISIBLE
    }

    fun backMenu(view: View) {
        val settingsMenu=findViewById<LinearLayout>(R.id.settingsMenu)
        settingsMenu.visibility= View.GONE

    }

    fun fullCal(view: View) {
        val intent= Intent(this,MainCalendarActivity::class.java)
        startActivity(intent)
    }
}