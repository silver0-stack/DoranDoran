package com.swu.doran.mailbox.sent.letter.list

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.letter.list.l_Data
import com.swu.doran.mailbox.send.SendActivity
import com.swu.doran.mailbox.sent.member.M_Data

class L_ContentsActivity:AppCompatActivity() {
    lateinit var datas: L_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var date: TextView
    lateinit var m_datas: M_Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sent_letter_contents)

        datas = (intent.getSerializableExtra("data") as? L_Data?)!!

        img = findViewById(R.id.img)
        name = findViewById(R.id.name)
        date = findViewById(R.id.datesent)

        Glide.with(this).load(datas.img).into(img)
        val user_name=datas.name.split(' ')
        name.text = user_name[0]
        date.text = datas.date



    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }
//
//    fun sendLetter(view: android.view.View) {
//        Intent(this, SendActivity::class.java).apply {
//            putExtra("data",datas)
//            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        }.run { startActivity(this) }
//    }
}