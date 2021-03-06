//package com.swu.doran
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.graphics.drawable.ClipDrawable
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import java.util.*
//import android.view.Gravity
//import android.widget.*
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import java.lang.String.format
//import java.text.SimpleDateFormat
//
//
//class MainCalendarActivity : AppCompatActivity() {
//    private lateinit var recyclerView_day: RecyclerView
//    private lateinit var viewAdapter_day: RecyclerView.Adapter<*>
//    private lateinit var viewManager_day: RecyclerView.LayoutManager
//
//    private lateinit var recyclerView_family: RecyclerView
//    private lateinit var viewAdapter_family: RecyclerView.Adapter<*>
//    private lateinit var viewManager_family: RecyclerView.LayoutManager
//
//    private lateinit var recyclerView_game: RecyclerView
//    private lateinit var viewAdapter_game: RecyclerView.Adapter<*>
//    private lateinit var viewManager_game: RecyclerView.LayoutManager
//
//    @SuppressLint("InflateParams", "WrongConstant")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.calendar_add)
//
//        viewManager_day = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
//        viewAdapter_day = MainDayAdapter()
//        recyclerView_day = findViewById<RecyclerView>(R.id.recyclerview_day).apply {
//            setHasFixedSize(true)
//            layoutManager = viewManager_day
//            adapter = viewAdapter_day
//        }
//
//        viewManager_family = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
//        viewAdapter_family = MainfamilyAdapter()
//        recyclerView_family = findViewById<RecyclerView>(R.id.recyclerview_family).apply {
//            setHasFixedSize(true)
//            layoutManager = viewManager_family
//            adapter = viewAdapter_family
//        }
//
//        viewManager_game = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
//        viewAdapter_game = MaingameAdapter()
//        recyclerView_game = findViewById<RecyclerView>(R.id.recyclerview_game).apply {
//            setHasFixedSize(true)
//            layoutManager = viewManager_game
//            adapter = viewAdapter_game
//        }
//
//        val calendarView = findViewById<CalendarView>(R.id.calendarView)
//        val addIssue = findViewById<TextView>(R.id.thisdayIssue)
//        //?????? ?????? ????????? ?????????
//        calendarView.setOnDateChangeListener { view, year, month, day ->
//            intent.putExtra("month", (month + 1).toString())
//            intent.putExtra("day", day.toString())
//            addIssue.text = "${month + 1} ??? ${day}??? ???????????????"
//
//        }
//
//        val month = intent.getStringExtra("month")
//        val day = intent.getStringExtra("day")
//
//        addIssue.setOnClickListener {
//            val intent = Intent(this, MainDayActivity::class.java)
//            intent.putExtra("month", month.toString())
//            intent.putExtra("day", day.toString())
//            startActivity(intent)
//        }
//
//
//
//    }
//
//}
package com.swu.doran.calendar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.swu.doran.R


class MainCalendarActivity : Fragment() {
    private lateinit var recyclerView_day: RecyclerView
    private lateinit var viewAdapter_day: RecyclerView.Adapter<*>
    private lateinit var viewManager_day: RecyclerView.LayoutManager

    private lateinit var recyclerView_family: RecyclerView
    private lateinit var viewAdapter_family: RecyclerView.Adapter<*>
    private lateinit var viewManager_family: RecyclerView.LayoutManager

    private lateinit var recyclerView_game: RecyclerView
    private lateinit var viewAdapter_game: RecyclerView.Adapter<*>
    private lateinit var viewManager_game: RecyclerView.LayoutManager

    //??????
    var userID: String = "userID"
    lateinit var fname: String
    lateinit var str: String


    private var uid:String = ""
    private lateinit var date:String
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.calendar_bottom_sheet, container, false)
        val calendarView = view.findViewById<CalendarView>(R.id.calendarView)  //????????????
        val addIssue = view.findViewById<TextView>(R.id.thisdayIssue)   //????????? ?????? ?????? ??????


        //?????? ?????? ????????? ?????????
        calendarView.setOnDateChangeListener { view, year, month, day ->
            activity?.intent?.putExtra("month", (month + 1).toString())
            activity?.intent?.putExtra("day", day.toString())
            addIssue.text = "${month + 1}??? ${day}??? ???????????????"


        }



        addIssue.setOnClickListener {
            //??????????????? ???????????? ????????????
            val instance = "(.+)??? (.+)???".toRegex()
            val day = addIssue.text

            //???????????? ???????????? ????????? ??????
            val matchResult : MatchResult? = instance.find(day)
            val value : String = matchResult!!.value


            val intent = Intent(activity , MainDayActivity::class.java)
            //intent.putExtra("month", month.toString())
            //intent.putExtra("day", day.toString())

            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference()

            val dataInput = Thisdate(
                value
            )
            myRef.child("day").child(value).child(uid).setValue(dataInput)



            intent.putExtra("day", value)
            startActivity(intent)

            //val database = FirebaseDatabase.getInstance()
            //val myRef = database.getReference()

            //val dataInput = Date(
            //    addIssue.text.toString()
            //)

            //myRef.child("day").child("game").push().setValue(dataInput)





        }

        return view
    }
}

//        viewManager_day = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
//        viewAdapter_day = MainDayAdapter()
//        recyclerView_day = findViewById<RecyclerView>(R.id.recyclerview_day).apply {
////            setHasFixedSize(true)
//            layoutManager = viewManager_day
//            adapter = viewAdapter_day
//        }
//
//        viewManager_family = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
//        viewAdapter_family = MainfamilyAdapter()
//        recyclerView_family = findViewById<RecyclerView>(R.id.recyclerview_family).apply {
////            setHasFixedSize(true)
//            layoutManager = viewManager_family
//            adapter = viewAdapter_family
//        }
//
//        viewManager_game = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
//        viewAdapter_game = MaingameAdapter()
//        recyclerView_game = findViewById<RecyclerView>(R.id.recyclerview_game).apply {
////            setHasFixedSize(true)
//            layoutManager = viewManager_game
//            adapter = viewAdapter_game
//        }

