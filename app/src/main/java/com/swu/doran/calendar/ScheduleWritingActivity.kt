package com.swu.doran.calendar

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.swu.doran.R
import com.swu.doran.account.RegisterUser
import java.util.*


//TODO:멘션 바텀시트 리사이클러뷰로 설정 후 유저 정보들 넣기
//TODO: 멘션 기능 어떻게 할지 ,.,
class ScheduleWritingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var database: DatabaseReference
    private lateinit var schedule: String
    private lateinit var startTime: String
    private lateinit var endTime: String
    private lateinit var loca: String
    private lateinit var time: String


    lateinit var time_before1: ToggleButton
    lateinit var time_before2: ToggleButton
    lateinit var time_before3: ToggleButton
    lateinit var time_before4: ToggleButton

    var timeString = ""

    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    lateinit var profileRef: DatabaseReference

    lateinit var shared: SharedPreferences

    lateinit var checkedTB:String

    lateinit var mention_iv:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_writing)

        user = FirebaseAuth.getInstance().currentUser
        uid = user?.uid

        shared = getSharedPreferences("profile_info", Context.MODE_PRIVATE)
        val edit = shared.edit()



        profileRef = accountReference.child(uid!!).child("profile")

        mention_iv=findViewById(R.id.mention)

        val backBtn = findViewById<ImageButton>(R.id.backBtn) //뒤로가기 버튼
        val schedule = findViewById<EditText>(R.id.schedule_text); //날짜(일정)
        val time_start_btn = findViewById<Button>(R.id.time_start_btn); //시작 시간
        val time_end_btn = findViewById<Button>(R.id.time_end_btn); //끝나는 시간
        val loca = findViewById<EditText>(R.id.loca_text); //위치

        time_before1 = findViewById<ToggleButton>(R.id.time_before1);  //10분전
        time_before2 = findViewById<ToggleButton>(R.id.time_before2);  //1시간전
        time_before3 = findViewById<ToggleButton>(R.id.time_before3);  //12시간
        time_before4 = findViewById<ToggleButton>(R.id.time_before4);  //24시간전

        val scheduleUpdateBtn = findViewById<ImageButton>(R.id.schedule_update_btn);  //업로드 버튼

        //뒤로가기 버튼
        backBtn.setOnClickListener {
            super.onBackPressed();
        }


        //멘션 이미지 클릭
        mention_iv.setOnClickListener {
            val bottomSheet =MentionBottomsheet(this)
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        time_before1.setOnClickListener(this)
        time_before2.setOnClickListener(this)
        time_before3.setOnClickListener(this)
        time_before4.setOnClickListener(this)


        //시작 시간 타임 피커 대화상자
        time_start_btn.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}시 ${minute}분"
                time_start_btn.text = timeString
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        //끝나는 시간 타임 피커 대화상자
        time_end_btn.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}시 ${minute}분"
                time_end_btn.text = timeString
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

//        //10분전 선택자
//        time_before1.setOnClickListener {
//            if (time_before1 != null) {
//                time_before1.isSelected = !time_before1.isSelected; }
//        }
//        //1시잔전 선택자
//        time_before2.setOnClickListener {
//            if (time_before2 != null) {
//                time_before2.isSelected = !time_before2.isSelected; }
//        }
//        //12시간전 선택자
//        time_before3.setOnClickListener {
//            if (time_before3 != null) {
//                time_before3.isSelected = !time_before3.isSelected; }
//        }
//        //24시간전 선택자
//        time_before4.setOnClickListener {
//            if (time_before4 != null) {
//                time_before4.isSelected = !time_before4.isSelected; }
//        }


//        //uid설정
//        if (intent.hasExtra("uid")) {
//            uid = intent.getStringExtra("uid").toString()
//        }

        //업로드 버튼 누르면
        scheduleUpdateBtn.setOnClickListener {

            val profile_number = shared.getInt("profile_number", 0)

            if (schedule.text.isNotEmpty() && loca.text.isNotEmpty()
                && time_start_btn.text == "시작 시간" && time_end_btn.text == "종료 시간"
            ) {


                val schedule_ = Schedule(
                    schedule.text.toString(),
                    time_start_btn.text.toString(),
                    time_end_btn.text.toString(),
                    loca.text.toString(),
                    "mention",
                    checkedTB)


                //리얼타임에 계정 저장
                profileRef.child("User$profile_number").child("calendar_schedule")
                    .setValue(schedule_)

                Toast.makeText(this, " 일정 글쓰기 완료", Toast.LENGTH_SHORT)
                    .show();

                val intent = Intent(this, MainDayActivity::class.java)
                startActivity(intent)


            } else {
                Toast.makeText(this, "입력을 확인해주세요", Toast.LENGTH_SHORT)
                    .show();
            }


        }

    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0) {
                time_before1 -> if (time_before1.isChecked) {
                    time_before1.isChecked = true

                    time_before2.isChecked = false
                    time_before3.isChecked = false
                    time_before4.isChecked = false

                    checkedTB=time_before1.text.toString()
                } else {
                    time_before1.isChecked = false
                }

                time_before2 -> if (time_before2.isChecked) {
                    time_before2.isChecked = true

                    time_before1.isChecked = false
                    time_before3.isChecked = false
                    time_before4.isChecked = false

                    checkedTB=time_before2.text.toString()
                } else {
                    time_before2.isChecked = false
                }

                time_before3 -> if (time_before3.isChecked) {
                    time_before3.isChecked = true

                    time_before2.isChecked = false
                    time_before1.isChecked = false
                    time_before4.isChecked = false

                    checkedTB=time_before3.text.toString()
                } else {
                    time_before3.isChecked = false
                }

                time_before4 -> if (time_before4.isChecked) {
                    time_before4.isChecked = true

                    time_before2.isChecked = false
                    time_before3.isChecked = false
                    time_before1.isChecked = false

                    checkedTB=time_before4.text.toString()
                } else {
                    time_before4.isChecked = false
                }
            }
        }
    }
}