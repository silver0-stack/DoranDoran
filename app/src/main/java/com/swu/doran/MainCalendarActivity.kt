package com.swu.doran

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import java.util.*
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.String.format
import java.text.SimpleDateFormat


class MainCalendarActivity : AppCompatActivity() {
    private lateinit var recyclerView_day: RecyclerView
    private lateinit var viewAdapter_day: RecyclerView.Adapter<*>
    private  lateinit var viewManager_day: RecyclerView.LayoutManager

    private lateinit var recyclerView_family: RecyclerView
    private lateinit var viewAdapter_family: RecyclerView.Adapter<*>
    private  lateinit var viewManager_family: RecyclerView.LayoutManager

    private lateinit var recyclerView_game: RecyclerView
    private lateinit var viewAdapter_game: RecyclerView.Adapter<*>
    private  lateinit var viewManager_game: RecyclerView.LayoutManager

    @SuppressLint("InflateParams", "WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_calendar)

        viewManager_day = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
        viewAdapter_day = MainDayAdapter()
        recyclerView_day = findViewById<RecyclerView>(R.id.recyclerview_day).apply{
            setHasFixedSize(true)
            layoutManager = viewManager_day
            adapter = viewAdapter_day
        }

        viewManager_family = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
        viewAdapter_family = MainfamilyAdapter()
        recyclerView_family = findViewById<RecyclerView>(R.id.recyclerview_family).apply{
            setHasFixedSize(true)
            layoutManager = viewManager_family
            adapter = viewAdapter_family
        }

        viewManager_game = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
        viewAdapter_game = MaingameAdapter()
        recyclerView_game = findViewById<RecyclerView>(R.id.recyclerview_game).apply{
            setHasFixedSize(true)
            layoutManager = viewManager_game
            adapter = viewAdapter_game
        }

        val inflater:LayoutInflater=layoutInflater
        val view=inflater.inflate(R.layout.main_day,null)
        val clickDate=view.findViewById<TextView>(R.id.clickDate)


        // get a calendar instance
        Calendar.getInstance()
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        //날짜 클릭 이벤트 리스너
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val intent = Intent(this@MainCalendarActivity, MainDayActivity::class.java)
            intent.putExtra("month", (month+1).toString())
            intent.putExtra("day", dayOfMonth.toString())
            startActivity(intent)
        }

        }


    }

//    @SuppressLint("ClickableViewAccessibility", "InflateParams")
//    fun selectType(view: android.view.View) {
//        // inflate the layout of the popup window
//        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val popupView: View = inflater.inflate(R.layout.calendar_popup, null);
//
//        // create the popup window
//        val width = LinearLayout.LayoutParams.WRAP_CONTENT;
//        val height = LinearLayout.LayoutParams.WRAP_CONTENT;
//        val focusable = true; // lets taps outside the popup also dismiss it
//        val popupWindow = PopupWindow(popupView, width, height, focusable)
//
//        // show the popup window
//        // which view you pass in doesn't matter, it is only used for the window tolken
//        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
//
//        // dismiss the popup window when touched
//        popupView.setOnTouchListener { v, event ->
//            popupWindow.dismiss()
//            true
//        }
//
//    }