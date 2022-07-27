package com.swu.doran.mailbox.recieved.member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.swu.doran.R
import com.swu.doran.mailbox.sent.member.sentMemberData

/*보낸 우체통 멤버 프래그먼트*/
class MailboxSentMember:Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var memberData: sentMemberData
    lateinit var memberAdapter: SentMemberAdapter
    lateinit var memberList: ArrayList<sentMemberData>


    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    var profile_name = firebaseDatabase.reference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.sent_member_list, container, false)

        recyclerView=view.findViewById(R.id.member_sent_recyclerv)

        memberList = ArrayList()

        //?
        memberAdapter= SentMemberAdapter(requireContext(),memberList)

        val linearLayoutManager= LinearLayoutManager(activity)
        recyclerView.layoutManager=linearLayoutManager
        recyclerView.adapter=memberAdapter


        return view
        //frag1과 연결시켜 return해줌.
    }
}