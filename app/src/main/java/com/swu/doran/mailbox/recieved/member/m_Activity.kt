package com.swu.doran.mailbox.recieved.member

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R

class m_Activity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    private lateinit var adapter: m_Adapter //adapter 객체 먼저 선언해주기!
    private var layoutmanager: RecyclerView.LayoutManager? = null

    val m_datas = mutableListOf<m_Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recieved_mailbox)

        recyclerview = findViewById(R.id.mailbox_member)
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
            add(m_Data(img = R.drawable.emoji_mother, name = "엄마", accumulated = 2, badge = "0"))
            add(m_Data(img = R.drawable.emoji_father, name = "아빠", accumulated = 3, badge = "+ 5"))
            add(m_Data(img = R.drawable.emoji_daughter_1, name = "언니", accumulated = 5, badge = "+ 3"))
            adapter.datas =  m_datas
            adapter.notifyDataSetChanged()
        }
    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }
}