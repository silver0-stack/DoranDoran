package com.swu.doran.profile.add


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.swu.doran.R

class Profile_name : AppCompatActivity() {
    var userName: EditText? = null

    //realtime
    // var uid: String? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_name)

        userName = findViewById(R.id.userName)




    }

    fun back(view: View?) {
        super.onBackPressed()
    }

    //이름,user Number를 intent 넘김
    fun next(view: View?) {
        val intent = intent
        var userN = intent.getIntExtra("user_number", 0)


        val input_name= userName?.text.toString()
        val intent_put=Intent(this, Profile_emoji::class.java)

        //유저 넘버 넘김
        intent_put.putExtra("user_number",userN)
        //입력한 이름 넘기기
        intent_put.putExtra("input_name",input_name)
        startActivity(intent)
    }
}