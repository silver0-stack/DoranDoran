package com.swu.doran.mailbox.sent.letter.list

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.letter.list.l_Data

class L_ContentsActivity:AppCompatActivity() {
    lateinit var L_datas: L_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var date: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sent_letter_contents)

        L_datas = (intent.getSerializableExtra("data") as? L_Data?)!!

        img = findViewById(R.id.img)
        name = findViewById(R.id.name)
        date = findViewById(R.id.datesent)

        Glide.with(this).load(L_datas.img).into(img)
        val user_name=L_datas.name.split(' ')
        name.text = user_name[0]
        date.text = L_datas.date

    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }

    //쪽지보내기
    fun toSend(view: android.view.View) {}
    fun sendLetter(view: android.view.View) {}
}