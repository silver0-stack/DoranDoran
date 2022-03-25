package com.swu.doran.mailbox.send

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.sent.member.M_Data

class SendLetterActivity:AppCompatActivity() {
    lateinit var datas: M_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_letter)

        datas = (intent.getSerializableExtra("data") as? M_Data?)!!
        img=findViewById(R.id.img)
        name=findViewById(R.id.name)

        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name
    }

    //보내기 버튼
    fun sendEmoji(view: android.view.View) {}
}