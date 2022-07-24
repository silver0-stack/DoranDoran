package com.swu.doran.profile.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swu.doran.R
import android.content.Intent
import android.graphics.Color
import android.view.TextureView
import android.view.View
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.swu.doran.profile.start.ProfileMenuActivity

class Profile_birthday : AppCompatActivity() {
    lateinit var lunar: TextView
    lateinit var solar: TextView

    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    lateinit var profileRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_birthday)

        lunar = findViewById(R.id.Lunar)
        solar = findViewById(R.id.Solar)

        user = FirebaseAuth.getInstance().currentUser
        assert(user != null)
        uid = user!!.uid

        profileRef = accountReference.child(uid!!).child("profile")

    }

    fun back(view: View?) {
        super.onBackPressed()
    }

    //프로필 설정 완료 버튼
    fun complete(view: View?) {

        //유저넘버, 인풋 네임 받기
        val intent = intent
        val user_number = intent.getIntExtra("user_number", 0)
        val input_name=intent.getStringExtra("input_name")


        //유저네임, 이미지, 생일 설정
        profileRef
            .child("User$userN")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataSnapshot in snapshot.children) {

                        // var profileName=snapshot.child("profile_name").getValue(String::class.java)
                        snapshot.child("profile_name").ref.setValue(userName?.text.toString())
                    }


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })
        startActivity(Intent(this, ProfileMenuActivity::class.java))
    }

    fun LunarOrSolar(view: View?) {
        if (view != null) {
            when (view.id) {
                //음력 클릭
                R.id.Lunar -> {
                    lunar.setTextColor(Color.parseColor("#F5C364"))
                    solar.setTextColor(Color.parseColor("#737171"))
                }

                //양력 클릭
                R.id.Solar -> {
                    lunar.setTextColor(Color.parseColor("#737171"))
                    solar.setTextColor(Color.parseColor("#F5C364"))

                }
            }
        }
    }
}