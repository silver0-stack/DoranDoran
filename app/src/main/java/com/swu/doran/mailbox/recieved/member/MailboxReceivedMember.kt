package com.swu.doran.mailbox.recieved.member

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.swu.doran.R

/*받은우체통 멤버 프래그먼트*/
class MailboxReceivedMember: Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var memberData: receivedMemberData
    lateinit var memberAdapter: ReceivedMemberAdapter
    lateinit var memberList: ArrayList<receivedMemberData>


    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    var profile_name = firebaseDatabase.reference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.received_member_list, container, false)

        recyclerView=view.findViewById(R.id.member_sent_recyclerv)

        memberList = ArrayList()

        //?
        memberAdapter= ReceivedMemberAdapter(requireContext(),memberList)

        val linearLayoutManager=LinearLayoutManager(activity)
        recyclerView.layoutManager=linearLayoutManager
        recyclerView.adapter=memberAdapter





        return view

    }
    fun ReadProfile() {
        accountReference.child(uid!!).child("profile")
            .addValueEventListener(object : ValueEventListener {

                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(snapshot: DataSnapshot) {
                    memberList.clear()

                    //Log.d("TAG", String.valueOf(snapshot));
                    for (dataSnapshot in snapshot.children) {
                        //val data_name = dataSnapshot.key
                        val read_p:receivedMemberData? = dataSnapshot.getValue(receivedMemberData::class.java)
                        //read_p?.key = data_name

                        memberList.add(read_p!!)
                        // Log.d("readPf_snap", data_name.toString())
//                        if (!read_p.cl) {
//                            gDialog.add(read_g)
//                        }
                    }
                    memberAdapter.notifyDataSetChanged()
                    recyclerView.adapter =memberAdapter
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, "불러오기 실패", Toast.LENGTH_SHORT).show()
                }
            })


    }
}