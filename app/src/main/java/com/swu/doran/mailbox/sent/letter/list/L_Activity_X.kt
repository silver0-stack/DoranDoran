package com.swu.doran.mailbox.sent.letter.list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.send.SendActivity
import com.swu.doran.mailbox.sent.member.M_Data
import com.swu.doran.profile.start.ProfileMenuActivity

//쪽지를 보냈으면 쪽지내용을 받을게 아니라 타이틀이 출력되야 함
//
class L_Activity_X : AppCompatActivity(){
    lateinit var datas: M_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var accumulated: TextView
    lateinit var recyclerview: RecyclerView
    private lateinit var adapter: L_Adapter //adapter 객체 먼저 선언해주기!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sent_letter_list_x)

        adapter = L_Adapter(this)
        datas = (intent.getSerializableExtra("data") as? M_Data?)!!
//        emoji_data = (intent.getSerializableExtra("emoji") as? Emoji_Data?)!!
        img = findViewById(R.id.img)
        name = findViewById(R.id.name)
        accumulated = findViewById(R.id.accumulated)

        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name
        accumulated.text = datas.accumulated.toString()
    }



    fun back(view: android.view.View) {
        super.onBackPressed()
    }

    fun sendLetter(view: android.view.View) {
        Intent(this, SendActivity::class.java).apply {
            putExtra("data", datas)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run { startActivity(this) }
    }

    fun send_letter(view: View) {
        Intent(this, SendActivity::class.java).apply {
            putExtra("data", datas)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run { startActivity(this) }
    }

}