package com.swu.doran.profile.edit

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R

class Profile_emoji : AppCompatActivity() {


    lateinit var next: TextView
    lateinit var editImg:ImageView

    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_emoji)

        editImg=findViewById(R.id.edit_img)
        next = findViewById(R.id.next)

        val intent = intent
        shared = getSharedPreferences("profile_info" , Context.MODE_PRIVATE)


//        val user_number = intent.getIntExtra("user_number", 0)
//            val input_name = intent.getStringExtra("input_name")
//
//        //profile_img 받은 정보(uri)
//        val profile_img=intent.getStringExtra("profile_img")



//        Log.d("프필 이름_이모지: ", ""+input_name.toString())
//        Log.d("프필 이미지_이모지: ", ""+profile_img.toString())
//
//
//        Log.d("uri_get", profile_img.toString())

        val get_img=shared.getString("profile_img","no")

        //혹시 get_img!=null 로 장치 필요한가?
        //선택한 이미지로 반영
        Glide.with(this)
            .load(get_img)
            .placeholder(R.drawable.loading)// Glide 로 이미지 로딩을 시작하기 전에 보여줄 이미지
            .fallback(R.drawable.loading) //load할 url이 null인 경우 등 비어있을 때
            .into(editImg)


        next.setOnClickListener {
            val put_intent = Intent(this, Profile_birthday::class.java)
//            //유저넘버, 인풋네임, 이미지 넘기기
//            intent.putExtra("user_number", user_number)
//            intent.putExtra("input_name", input_name)
//            intent.putExtra("profile_img", profile_img)
            startActivity(put_intent)
        }

    }


    fun back(view: View?) {
        super.onBackPressed()
    }

    //프사 선택
    fun selectImg(view: View?) {
        startActivity(Intent(this, Profile_select_emoji::class.java))
    }


}