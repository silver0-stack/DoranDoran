package com.swu.doran.mailbox.recieved.letter.list

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.member.m_Data

class l_contentsActivity : AppCompatActivity() {
    lateinit var l_datas: l_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var date: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.received_letter_contents)

        l_datas = intent.getSerializableExtra("data") as l_Data


        img = findViewById(R.id.img)
        name = findViewById(R.id.name)
        date = findViewById(R.id.datesent)

        Glide.with(this).load(l_datas.img).into(img)
        val user_name=l_datas.name.split(' ')
        name.text = user_name[0]
        date.text = l_datas.date

    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }
}