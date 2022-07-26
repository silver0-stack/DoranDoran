package com.swu.doran.profile.add

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.swu.doran.R
import com.swu.doran.profile.start.ProfileMenuActivity
import java.util.*

class Profile_birthday : AppCompatActivity(), View.OnClickListener {
    lateinit var lunar: MaterialButton
    lateinit var solar: MaterialButton

    lateinit var complete: TextView
    lateinit var back: TextView

    lateinit var msg: String

    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    lateinit var profileRef: DatabaseReference

    lateinit var lunar_or_solar: String

    lateinit var shared: SharedPreferences


    @Nullable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_birthday)

        shared = getSharedPreferences("profile_info", Context.MODE_PRIVATE)
        val edit = shared.edit()

        back = findViewById(R.id.back)
        complete = findViewById(R.id.complete)

        back.setOnClickListener {
            super.onBackPressed()
        }

        val datePicker = findViewById<View>(R.id.dataPicker) as DatePicker
        val today = Calendar.getInstance()
        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month_ = month + 1
            //안 움직이고 오늘 날짜로 하니까 msg 미초기화 에러 발생
            msg = "$year/$month_/$day"


            edit.putString("profile_birth", msg)
            Toast.makeText(this, "$msg Was Saved", Toast.LENGTH_SHORT).show()
            edit.apply()

//            Toast.makeText(applicationContext, "$msg 를 선택하셨습니다", Toast.LENGTH_SHORT).show()

        }
        //datePicker.setOnDateChangedListener(this);
        val listener = DatePicker.OnDateChangedListener { view, year, monthOfYear, dayOfMonth ->

        }


        lunar = findViewById(R.id.lunar)
        solar = findViewById(R.id.solar)


        lunar.setOnClickListener(this)
        solar.setOnClickListener(this)

        user = FirebaseAuth.getInstance().currentUser
        assert(user != null)
        uid = user!!.uid

        profileRef = accountReference.child(uid!!).child("profile")

//        val intent = intent
//        //유저네임,인풋네임,프필 이미지 받기
//        val profile_num = intent.getIntExtra("user_number", 0)
//        val profile_name = intent.getStringExtra("input_name")
//        val profile_img = intent.getStringExtra("profile_img")


//        Log.d("프필 이름_생일: ", ""+profile_name.toString())
//        Log.d("프필 이미지_생일: ", ""+profile_img.toString())


        //완료버튼
        complete.setOnClickListener {

            val profile_number = shared.getInt("profile_number",0)
            val profile_name = shared.getString("profile_name", "no")
            val profile_img = shared.getString("profile_img", "no")

            Log.d("shared_profile_number: ", profile_number.toString())
            Log.d("shared_profile_name: ", profile_name.toString())
            Log.d("shared_profile_img: ", profile_img.toString())


            //유저네임, 이미지, 생일 설정
            profileRef
                .child("User$profile_number")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for (dataSnapshot in snapshot.children) {

                            // var profileName=snapshot.child("profile_name").getValue(String::class.java)
                            snapshot.child("profile_name").ref.setValue(profile_name.toString())
                            snapshot.child("profile_img").ref.setValue(profile_img.toString())
                            snapshot.child("profile_birth").ref.setValue(msg)
                            snapshot.child("profile_LunarOrSolar").ref.setValue(lunar_or_solar)
                        }


                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }


                })
            startActivity(Intent(this, ProfileMenuActivity::class.java))
        }


    }


    override fun onClick(p0: View?) {

        if (p0 != null) {
            when (p0.id) {
                //음력 클릭
                R.id.lunar -> {
                    lunar_or_solar = lunar.text.toString()
//                    lunar.setTextColor(Color.parseColor("#F5C364"))
//                    solar.setTextColor(Color.parseColor("#737171"))
                }

                //양력 클릭
                R.id.solar -> {
                    lunar_or_solar = solar.text.toString()
//                    lunar.setTextColor(Color.parseColor("#737171"))
//                    solar.setTextColor(Color.parseColor("#F5C364"))

                }

            }
        }


//    fun LunarOrSolar(view: View?) {
//        if (view != null) {
//            when (view.id) {
//                //음력 클릭
//                R.id.Lunar -> {
//                    lunar.setTextColor(Color.parseColor("#F5C364"))
//                    solar.setTextColor(Color.parseColor("#737171"))
//                }
//
//                //양력 클릭
//                R.id.Solar -> {
//                    lunar.setTextColor(Color.parseColor("#737171"))
//                    solar.setTextColor(Color.parseColor("#F5C364"))
//
//                }
//            }
//        }
//    }
//
//    override fun onClick(v: View?) {
//        if (v != null) {
//            when (v) {
//                lunar -> if (lunar.isChecked) {
//                    lunar.isChecked = true
//                    Toast.makeText(applicationContext, "음력 클릭", Toast.LENGTH_SHORT).show()
//
//                    solar.isChecked = false
//
//                } else {
//                    lunar.isChecked = false
//                }
//
//                solar -> if (solar.isChecked) {
//                    solar.isChecked = true
//                    Toast.makeText(applicationContext, "양력 클릭", Toast.LENGTH_SHORT).show()
//
//                    lunar.isChecked = false
//
//                } else {
//                    solar.isChecked = false
//                }
//
//            }
//        }
//    }

    }
}