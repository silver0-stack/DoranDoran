package com.swu.doran


import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class AddIssueActivity:AppCompatActivity() {
//    lateinit var addIssue: TextView
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.calendar_add)
//
//        val month = intent.getStringExtra("month")
//        val day = intent.getStringExtra("day")
//        addIssue = findViewById(R.id.thisdayIssue)
//        addIssue.text = month+"월 "+day+"일 추억남기기"
//
//        val calendarView = findViewById<CalendarView>(R.id.calendarView)
//        //날짜 클릭 이벤트 리스너
//        calendarView.setOnDateChangeListener { view, year, month, day ->
//            val intent = Intent(this, AddIssueActivity::class.java)
//            intent.putExtra("month", (month+1).toString())
//            intent.putExtra("day", day.toString())
//            startActivity(intent)
//
//        }
//
//
//        addIssue.setOnClickListener {
//            val intent = Intent(this, MainDayActivity::class.java)
//            intent.putExtra("month", month.toString())
//            intent.putExtra("day", day.toString())
//            startActivity(intent)
//        }
//    }
}
