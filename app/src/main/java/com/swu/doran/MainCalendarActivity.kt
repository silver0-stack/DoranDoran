package com.swu.doran

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import java.util.*
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainCalendarActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_calendar)

        val spinner = findViewById<Spinner>(R.id.spinner)

        // get a calendar instance
        val calendar = Calendar.getInstance()
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->


        }

        //어댑터 설정 -resource-array.xml에 있는 아이템 목록을 추가한다
        spinner.adapter=ArrayAdapter.createFromResource(this,R.array.my_array,android.R.layout.simple_spinner_item)
        //아이템 선택 리스너
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                   //선택 안함
                    0->{}
                    1->{}
                    2->{}
                    3->{}

                }                }

        }


    }

    @SuppressLint("ClickableViewAccessibility", "InflateParams")
    fun selectType(view: android.view.View) {
        // inflate the layout of the popup window
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.calendar_popup, null);

        // create the popup window
        val width = LinearLayout.LayoutParams.WRAP_CONTENT;
        val height = LinearLayout.LayoutParams.WRAP_CONTENT;
        val focusable = true; // lets taps outside the popup also dismiss it
        val popupWindow = PopupWindow(popupView, width, height, focusable)

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        // dismiss the popup window when touched
        popupView.setOnTouchListener { v, event ->
            popupWindow.dismiss()
            true
        }

    }
}