package com.swu.doran.profile.edit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.swu.doran.R
import com.swu.doran.profile.start.ProfileData
import com.swu.doran.profile.start.ProfileMenuActivity

/*아이템 수정하는 액티비티*/
class ProfileEditActivity : ProfileMenuActivity() {

    lateinit var edit_complete: TextView
    lateinit var editAdapter: ProfileEditAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_edit)

        recyclerv = findViewById(R.id.profile_rv)

        userList = ArrayList()
        editAdapter = ProfileEditAdapter(this, userList)
        recyclerv.adapter = userAdapter

        val gridLayoutManager = GridLayoutManager(applicationContext, 3)
        recyclerv.layoutManager = gridLayoutManager
        recyclerv.setHasFixedSize(true)

        // val icon = BitmapFactory.decodeResource(resources, R.drawable.user)


        user = FirebaseAuth.getInstance().currentUser
        assert(user != null)
        uid = user!!.uid

        edit_complete = findViewById(R.id.edit_complete)

        edit_complete.setOnClickListener {
            startActivity(Intent(this, ProfileMenuActivity::class.java))
        }
        //항상 프로필 읽어오기
        ReadEditProfile()
    }
    fun ReadEditProfile() {
        accountReference.child(uid!!).child("profile")
            .addValueEventListener(object : ValueEventListener {

                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(snapshot: DataSnapshot) {
                    userList.clear()

                    //Log.d("TAG", String.valueOf(snapshot));
                    for (dataSnapshot in snapshot.children) {
                        //val data_name = dataSnapshot.key
                        val read_p: ProfileData? = dataSnapshot.getValue(ProfileData::class.java)
                        //read_p?.key = data_name

                        userList.add(read_p!!)
                        // Log.d("readPf_snap", data_name.toString())
//                        if (!read_p.cl) {
//                            gDialog.add(read_g)
//                        }
                    }
                    editAdapter.notifyDataSetChanged()
                    recyclerv.adapter = editAdapter
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "불러오기 실패", Toast.LENGTH_SHORT).show()
                }
            })


    }
    /*
    lateinit var profileName: EditText

    lateinit var clear: ImageView




        clear = findViewById(R.id.clear)
        completeProfileEdit = findViewById(R.id.completeProfileEdit)
        profileName = findViewById(R.id.profileName)
        val layout= LinearLayoutManager(this)
        profile_rv.layoutManager=layout
        profile_rv.setHasFixedSize(true)

        val profileName = profileName.text.toString().trim()


        //x표시 메소드
        clear.setOnClickListener {
            adapter.removeItem(clickcount)
           startActivity(Intent(this,ProfileMenuActivity::class.java))

        }
        //수정 완료 메소드
        completeProfileEdit.setOnClickListener {
            adapter.addItem(ProfileData("user", profileName))
            startActivity(Intent(this,ProfileMenuActivity::class.java))
        }

    }

    //프사 변경 메소드
    fun modifyPFP(view: android.view.View) {


    }


    //프로필 삭제 메솓,
    fun deleteProfile(view: android.view.View) {

    }

     */

}