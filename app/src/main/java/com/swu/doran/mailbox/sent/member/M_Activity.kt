package com.swu.doran.mailbox.sent.member

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.member.m_Activity
import com.swu.doran.mailbox.recieved.member.m_Adapter
import com.swu.doran.mailbox.recieved.member.m_Data

class M_Activity:AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    private lateinit var adapter: M_Adapter //adapter 객체 먼저 선언해주기!
    private var layoutmanager: RecyclerView.LayoutManager? = null

    val M_datas = mutableListOf<M_Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sent_mailbox)

        recyclerview = findViewById(R.id.sent_member)
        initRecycler()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler() {
        adapter = M_Adapter(this)
        layoutmanager= LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager=layoutmanager
        recyclerview.adapter = adapter


        M_datas.apply {
            add(M_Data(img = R.drawable.emoji_mother, name = "엄마", accumulated = 10))
            add(M_Data(img = R.drawable.emoji_father, name = "아빠", accumulated = 7))
            add(M_Data(img = R.drawable.emoji_daughter_1, name = "언니", accumulated = 5))
            adapter.datas =  M_datas
            adapter.notifyDataSetChanged()
        }
    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }
    //스크랩버튼
    fun toScrap(view: android.view.View) {

    }
    fun toReceivedLetter(view: android.view.View) {
        startActivity(Intent(this,m_Activity::class.java))
    }
}