package com.swu.doran.mailbox.recieved.letter.list

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Insets.add
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.letter.scrap.s_Activity
import com.swu.doran.mailbox.recieved.member.m_Data

class l_Activity:AppCompatActivity() {
    lateinit var datas: m_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var accumulated: TextView
    lateinit var badge: Button

    lateinit var recyclerview: RecyclerView
    private lateinit var adapter: l_Adapter //adapter 객체 먼저 선언해주기!
    private var layoutmanager: RecyclerView.LayoutManager? = null
    val l_datas = mutableListOf<l_Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recieved_letter_list)

        datas = (intent.getSerializableExtra("data") as m_Data?)!!

        img = findViewById(R.id.img)
        name = findViewById(R.id.name)
        accumulated = findViewById(R.id.accumulated)
        badge = findViewById(R.id.badge)

        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name
        accumulated.text = datas.accumulated.toString()
        badge.text =datas.badge

        recyclerview = findViewById(R.id.received_letter_list)
        initRecycler()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler() {
        adapter = l_Adapter(this)
        layoutmanager= LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager=layoutmanager
        recyclerview.adapter = adapter


        l_datas.apply {
            add(l_Data(img = datas.img, name = name.text.toString()+" 님이 이모티콘으로 감정을 표현했어요", date="2022.01.12", scrap = R.drawable.star))
            add(l_Data(img = R.drawable.unread_letter, name = name.text.toString()+" 님이 편지를 보냈어요", date="2022.01.22", scrap = R.drawable.star))
            add(l_Data(img = R.drawable.read_letter, name = name.text.toString()+" 님이 편지를 보냈어요", date="2022.02.12", scrap = R.drawable.yellow_star))
            adapter.datas = l_datas
            adapter.notifyDataSetChanged()
        }
    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }

    fun scrapBtn(view: android.view.View) {
        startActivity(Intent(this,s_Activity::class.java))
    }
}