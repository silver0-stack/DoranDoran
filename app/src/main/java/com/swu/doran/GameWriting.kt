package com.swu.doran

import android.app.DatePickerDialog
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

class GameWriting : AppCompatActivity() {

    private lateinit var database:DatabaseReference
    private lateinit var title:String
    private lateinit var startdate:String
    private lateinit var enddate:String
    private lateinit var reward:String


    private var uid:String = ""
    var timeString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_writing)

        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        val title = findViewById<EditText>(R.id.titleText)  //내기 제목
        val date_start_btn= findViewById<Button>(R.id.date_start_btn)  //시작 날짜
        val date_end_btn = findViewById<Button>(R.id.date_end_btn)  //끝나는 날짜
        val reward = findViewById<EditText>(R.id.rewardTxt)  //보상
        val day1Btn = findViewById<TextView>(R.id.day1_btn)  //하루전
        val day2Btn = findViewById<TextView>(R.id.day2_btn)
        val day3Btn = findViewById<TextView>(R.id.day3_btn)
        val day4Btn = findViewById<TextView>(R.id.day4_btn)
        val updateBtn = findViewById<ImageButton>(R.id.game_update_btn)


        //뒤로가기
        backBtn.setOnClickListener{
            super.onBackPressed();
        }


        //시작 날자 데이트 피커
        date_start_btn.setOnClickListener{
            val cal = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                timeString = "${year}년 ${month+1}월 ${dayOfMonth}일"
                date_start_btn.text = timeString
            }
            DatePickerDialog(this, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        //끝나는 날짜 데이트 피커
        date_end_btn.setOnClickListener{
            val cal = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                timeString = "${year}년 ${month+1}월 ${dayOfMonth}일"
                date_end_btn.text = timeString
            }
            DatePickerDialog(this, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }


        day1Btn.setOnClickListener {
            if (day1Btn != null) {
                day1Btn.isSelected = !day1Btn.isSelected;
                //day1Btn.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.white)) } }
            }
        }
            day2Btn.setOnClickListener {
                if (day2Btn != null) {
                    day2Btn.isSelected = !day2Btn.isSelected; }
            }
            day3Btn.setOnClickListener {
                if (day3Btn != null) {
                    day3Btn.isSelected = !day3Btn.isSelected; }
            }
            day4Btn.setOnClickListener {
                if (day4Btn != null) {
                    day4Btn.isSelected = !day4Btn.isSelected; }
            }


        if(intent.hasExtra("uid")){
            uid = intent.getStringExtra("uid").toString()
        }




        //올리기 버튼
        updateBtn.setOnClickListener{
            //오늘날짜 받아옴
            val instance = intent.getStringExtra("day")

            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference()

            val dataInput = game(
                title.text.toString(),
                date_start_btn.text.toString(),
                date_end_btn.text.toString(),
                reward.text.toString()
            )
            if (instance != null) {
                myRef.child("day").child(instance).child("game").child(uid).setValue(dataInput)
            }

            onBackPressed()

            //val intent = Intent(this, MainDayActivity::class.java)
            //startActivity(intent)
        }





    }
}