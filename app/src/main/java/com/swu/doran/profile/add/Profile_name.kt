package com.swu.d

import com.swu.doran.profile.add.Profile_emoji



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

    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    lateinit var profileRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_name)

        userName = findViewById(R.id.userName)

        user = FirebaseAuth.getInstance().currentUser
        assert(user != null)
        uid = user!!.uid

        profileRef = accountReference.child(uid!!).child("profile")


    }

    fun back(view: View?) {
        super.onBackPressed()
    }

    fun next(view: View?) {
        val intent = intent
        var userN = intent.getIntExtra("user_number", 0)

        profileRef
            .child("User$userN")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataSnapshot in snapshot.children) {

                        var profileName=snapshot.child("profile_name").getValue(String::class.java)
                       // userName.value
                    }


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })
        startActivity(Intent(this, Profile_emoji::class.java))
    }
}