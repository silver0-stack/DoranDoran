package com.swu.doran

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class ScheduleWritingActivity : AppCompatActivity() {

    private lateinit var database:DatabaseReference
    private lateinit var schedule:String
    private lateinit var startTime:String
    private lateinit var endTime:String
    private lateinit var loca:String
    private lateinit var time:String

    private var uid:String = ""

    var timeString = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_writing)

        val backBtn = findViewById<ImageButton>(R.id.backBtn) //뒤로가기 버튼
        val schedule = findViewById<EditText>(R.id.schedule_text); //날짜(일정)
        val time_start_btn = findViewById<Button>(R.id.time_start_btn); //시작 시간
        val time_end_btn = findViewById<Button>(R.id.time_end_btn); //끝나는 시간
        val loca = findViewById<EditText>(R.id.loca_text); //위치
        val time_before1 = findViewById<TextView>(R.id.time_before1);  //10분전
        val time_before2 = findViewById<TextView>(R.id.time_before2);  //1시간전
        val time_before3 = findViewById<TextView>(R.id.time_before3);  //12시간
        val time_before4 = findViewById<TextView>(R.id.time_before4);  //24시간전
        val scheduleUpdateBtn = findViewById<ImageButton>(R.id.schedule_update_btn);  //업로드 버튼

        //뒤로가기 버튼
            backBtn.setOnClickListener{
                val intent = Intent(this, MainDayActivity::class.java)
                startActivity(intent)
            }

        //시작 시간 타임 피커 대화상자
            time_start_btn.setOnClickListener{
                val cal = Calendar.getInstance()
                val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}시 ${minute}분"
                time_start_btn.text = timeString
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()
        }

        //끝나는 시간 타임 피커 대화상자
        time_end_btn.setOnClickListener{
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}시 ${minute}분"
                time_end_btn.text = timeString
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()
        }

        //10분전 선택자
        time_before1.setOnClickListener{
            if (time_before1 != null) {
                time_before1.isSelected = !time_before1.isSelected; }
        }
        //1시잔전 선택자
        time_before2.setOnClickListener{
            if (time_before2 != null) {
                time_before2.isSelected = !time_before2.isSelected; }
        }
        //12시간전 선택자
        time_before3.setOnClickListener{
            if (time_before3 != null) {
                time_before3.isSelected = !time_before3.isSelected; }
        }
        //24시간전 선택자
        time_before4.setOnClickListener{
            if (time_before4 != null) {
                time_before4.isSelected = !time_before4.isSelected; }
        }



        //uid설정
        if(intent.hasExtra("uid")){
            uid = intent.getStringExtra("uid").toString()
        }
        //업로드 버튼 누르면
        scheduleUpdateBtn.setOnClickListener{
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference()

            val dataInput = Schedule(
                schedule.text.toString(),
                time_start_btn.text.toString(),
                time_end_btn.text.toString(),
                loca.text.toString(),
                time_before1.text.toString()
            )
            myRef.child("day").child("schedule").child(uid).push().setValue(dataInput)


            val intent = Intent(this, MainDayActivity::class.java)
            startActivity(intent)
        }

    }
}