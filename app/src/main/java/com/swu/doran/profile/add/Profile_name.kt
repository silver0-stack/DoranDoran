package com.swu.doran.profile.add


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.swu.doran.R

class Profile_name : AppCompatActivity() {
    var userName: EditText? = null

    lateinit var next:TextView
    //realtime
    // var uid: String? = null


    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_name)


        shared = getSharedPreferences("profile_info" , Context.MODE_PRIVATE)
        userName = findViewById(R.id.userName)


        next=findViewById(R.id.next)

        next.setOnClickListener{
            //이름,user Number를 intent 넘김

//            val intent = intent
//            val userN = intent.getIntExtra("user_number", 0)


            val input_name= userName?.text.toString()

            val edit = shared.edit()
            edit.putString("profile_name" ,input_name)
            Toast.makeText(this , "$input_name Was Saved" , Toast.LENGTH_SHORT).show()
            edit.apply()


            val intent_put= Intent(this, Profile_emoji::class.java)

            //유저 넘버 넘김
         //   intent_put.putExtra("user_number",userN)
            //입력한 이름 넘기기
           // intent_put.putExtra("input_name",input_name)
            startActivity(intent_put)
        }

    }

    fun back(view: View?) {
        super.onBackPressed()
    }



}