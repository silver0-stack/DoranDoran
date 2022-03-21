package com.swu.doran

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//
@SuppressLint("WrongViewCast")
class MainDayActivity : AppCompatActivity() {
    private lateinit var recyclerView_day: RecyclerView
    private lateinit var viewAdapter_day: RecyclerView.Adapter<*>
    private  lateinit var viewManager_day: RecyclerView.LayoutManager

    private lateinit var recyclerView_family: RecyclerView
    private lateinit var viewAdapter_family: RecyclerView.Adapter<*>
    private  lateinit var viewManager_family: RecyclerView.LayoutManager

    private lateinit var recyclerView_game: RecyclerView
    private lateinit var viewAdapter_game: RecyclerView.Adapter<*>
    private  lateinit var viewManager_game: RecyclerView.LayoutManager

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_day)


        viewManager_day = LinearLayoutManager(this, HORIZONTAL, true)
        viewAdapter_day = MainDayAdapter()
        recyclerView_day = findViewById<RecyclerView>(R.id.recyclerview_day).apply{
            setHasFixedSize(true)
            layoutManager = viewManager_day
            adapter = viewAdapter_day
        }

        viewManager_family = LinearLayoutManager(this, HORIZONTAL, true)
        viewAdapter_family = MainfamilyAdapter()
        recyclerView_family = findViewById<RecyclerView>(R.id.recyclerview_family).apply{
            setHasFixedSize(true)
            layoutManager = viewManager_family
            adapter = viewAdapter_family
        }

        viewManager_game = LinearLayoutManager(this, HORIZONTAL, true)
        viewAdapter_game = MaingameAdapter()
        recyclerView_game = findViewById<RecyclerView>(R.id.recyclerview_game).apply{
            setHasFixedSize(true)
            layoutManager = viewManager_game
            adapter = viewAdapter_game
        }

        val scheduleBtn = findViewById<ImageButton>(R.id.scheduleBtn)
        val familyBtn = findViewById<ImageButton>(R.id.familyBtn)
        val gameBtn = findViewById<ImageButton>(R.id.gameBtn)
        val icon_back =findViewById<ImageButton>(R.id.back)

        val date = findViewById<TextView>(R.id.clickDate)

        val month = intent.getStringExtra("month")
        val day = intent.getStringExtra("day")

        date.text = month+"월 "+day+"일"

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

        icon_back.setOnClickListener{
            val intent = Intent(this, MainCalendarActivity::class.java)
            startActivity(intent)
        }



    }
}