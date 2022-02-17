package com.swu.doran.mailbox.send

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.sent.member.M_Data

class SendActivity:AppCompatActivity() {
    lateinit var datas: M_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_message)

        datas = (intent.getSerializableExtra("data") as? M_Data?)!!
        img=findViewById(R.id.img)
        name=findViewById(R.id.name)

        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name
    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }
    fun toSendEmoji(view: android.view.View) {
        Intent(this, SendEmojiActivity::class.java).apply {
            putExtra("data",datas)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run { startActivity(this) }
    }
    fun toSendLetter(view: android.view.View) {
        Intent(this, SendLetterActivity::class.java).apply {
            putExtra("data",datas)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run { startActivity(this) }
    }
}