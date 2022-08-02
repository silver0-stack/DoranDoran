package com.swu.doran.calendar

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.swu.doran.R

class MentionBottomsheet(context: Context) : BottomSheetDialogFragment() {

    lateinit var cancel: TextView
    lateinit var ok: TextView
    lateinit var recyclerv: RecyclerView
    lateinit var userData: MentionSelect
    lateinit var MentionResult: MentionResult
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
    lateinit var profileRef: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.bottomsheet_mention, container, false)

        recyclerv = view.findViewById(R.id.mention_bottomSheet)

        userList = ArrayList()
        userAdapter = context?.let { MentionSelectAdapter(it, userList) }!!
        recyclerv.adapter = userAdapter

        val LayoutManager =LinearLayoutManager(context)
        recyclerv.layoutManager = LayoutManager
        recyclerv.setHasFixedSize(true)



        user = FirebaseAuth.getInstance().currentUser
        assert(user != null)
        uid = user!!.uid

        profileRef = accountReference.child(uid!!).child("profile")
        //항상 프로필 읽어오기
        ReadProfile()


        return view
    }

  private fun ReadProfile() {

        accountReference.child(uid!!).child("profile").addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()

                //Log.d("TAG", String.valueOf(snapshot));
                for (dataSnapshot in snapshot.children) {
                    //val data_name = dataSnapshot.key
                    val read_name= dataSnapshot.child("profile_name").getValue(String::class.java)
                    val read_img = dataSnapshot.child("profile_img").getValue(String::class.java)
                    //read_p?.key = data_name
                    Log.d("read_name: ", read_name.toString())
                    Log.d("read_img: ", read_img.toString())

                    userData= MentionSelect(read_img.toString(), read_name.toString())

//                    userData.image= read_img.toString()
//                    userData.name=read_name.toString()
                    userList.add(userData)
                    // Log.d("readPf_snap", data_name.toString())
//                        if (!read_p.cl) {
//                            gDialog.add(read_g)
//                        }
                }
                userAdapter.notifyDataSetChanged()
                recyclerv.adapter = userAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "불러오기 실패", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        view?.findViewById<Button>(R.id.button_bottom_sheet)?.setOnClickListener {
//            Toast.makeText(context, "Bottom Sheet 안의 버튼 클릭", Toast.LENGTH_SHORT).show()
//            dismiss()
//        }
    }
}