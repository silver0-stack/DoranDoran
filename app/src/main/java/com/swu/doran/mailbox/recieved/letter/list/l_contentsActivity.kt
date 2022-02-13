package com.swu.doran.mailbox.recieved.letter.list

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.member.m_Data

class l_contentsActivity : AppCompatActivity() {
    lateinit var l_datas: l_Data
    lateinit var m_datas: m_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var date: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.received_letter_contents)

        l_datas = intent.getSerializableExtra("data") as l_Data
        m_datas = intent.getSerializableExtra("data") as m_Data
        img = findViewById(R.id.img)
        name = findViewById(R.id.name)
        date = findViewById(R.id.datesent)

        Glide.with(this).load(m_datas.img).into(img)
        name.text = m_datas.name
        date.text = l_datas.date

    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }
}