package com.swu.doran.mailbox.recieved.letter.scrap

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.letter.list.l_Activity
import com.swu.doran.mailbox.recieved.member.m_Data

class s_Activity:AppCompatActivity() {
    lateinit var datas: m_Data
    lateinit var img:ImageView
    lateinit var name:TextView
    lateinit var accumulated:TextView
    lateinit var badge:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recieved_letter_scrap)

        datas=intent.getSerializableExtra("data") as m_Data
        img=findViewById(R.id.img)
        name=findViewById(R.id.name)
        accumulated=findViewById(R.id.accumulated)
        badge=findViewById(R.id.badge)

        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name
        accumulated.text = datas.accumulated.toString()
        badge.text =datas.badge
    }

    //cant solve error..
    fun listBtn(view: android.view.View) {
        //startActivity(Intent(this,L_Activity::class.java))
        super.onBackPressed()
    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }
}