package com.swu.doran.calendar

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.swu.doran.R

class ProfileMentionActivity : AppCompatActivity() {
    lateinit var cancel: TextView
    lateinit var ok: TextView
    lateinit var recyclerv: RecyclerView
    lateinit var userData: MentionSelect
    lateinit var userAdapter: MentionSelectAdapter
    lateinit var userList: ArrayList<MentionSelect>


    var storage: FirebaseStorage = FirebaseStorage.getInstance()
    var storageRef: StorageReference = storage.reference //뽑아오는 스토리지


    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    var profile_name = firebaseDatabase.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.swu.doran.R.layout.profile_mention)




        cancel = findViewById(R.id.cancel)
        ok = findViewById(com.swu.doran.R.id.ok)

        recyclerv = findViewById(com.swu.doran.R.id.profile_rv)

        userList = ArrayList()
        userAdapter = MentionSelectAdapter(this, userList)
        recyclerv.adapter = userAdapter

        val gridLayoutManager = GridLayoutManager(applicationContext, 3)
        recyclerv.layoutManager = gridLayoutManager
        recyclerv.setHasFixedSize(true)



        user = FirebaseAuth.getInstance().currentUser
        assert(user != null)
        uid = user!!.uid








        cancel.setOnClickListener {
            super.onBackPressed()
        }


        ok.setOnClickListener {
            startActivity(Intent(this, ScheduleWritingActivity::class.java))
        }


        //항상 프로필 읽어오기
        ReadProfile()

    }

    fun ReadProfile() {
        val profileRef: DatabaseReference = accountReference.child(uid!!).child("profile")
        profileRef.addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()

                //Log.d("TAG", String.valueOf(snapshot));
                for (dataSnapshot in snapshot.children) {
                    //val data_name = dataSnapshot.key
                    val read_p: MentionSelect? = dataSnapshot.getValue(MentionSelect::class.java)
                    //read_p?.key = data_name

                    userList.add(read_p!!)
                    // Log.d("readPf_snap", data_name.toString())
//                        if (!read_p.cl) {
//                            gDialog.add(read_g)
//                        }
                }
                userAdapter.notifyDataSetChanged()
                recyclerv.adapter = userAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "불러오기 실패", Toast.LENGTH_SHORT).show()
            }
        })


    }
}