package com.swu.doran.mailbox.recieved.member

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R
import com.swu.doran.mailbox.sent.member.M_Activity

class m_Activity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    private lateinit var adapter: m_Adapter //adapter 객체 먼저 선언해주기!
    private var layoutmanager: RecyclerView.LayoutManager? = null

    val m_datas = mutableListOf<m_Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recieved_mailbox)

        recyclerview = findViewById(R.id.received_member)
        initRecycler()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler() {
        adapter = m_Adapter(this)
        layoutmanager=LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager=layoutmanager
        recyclerview.adapter = adapter


        m_datas.apply {
            add(m_Data(img = R.drawable.mom01, name = "엄마", accumulated = 2, badge = "0"))
            add(m_Data(img = R.drawable.dad01, name = "아빠", accumulated = 3, badge = "+ 5"))
            add(m_Data(img = R.drawable.girl_10s_02, name = "언니", accumulated = 5, badge = "+ 3"))
            adapter.datas =  m_datas
            adapter.notifyDataSetChanged()
        }
    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }

    //보낸편지함버튼
    fun toSentLetter(view: android.view.View) {
        startActivity(Intent(this, M_Activity::class.java))
    }
}