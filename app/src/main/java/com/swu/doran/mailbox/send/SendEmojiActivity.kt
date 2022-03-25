package com.swu.doran.mailbox.send

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.mailbox.sent.letter.list.L_Activity
import com.swu.doran.mailbox.sent.member.M_Data
import android.view.View
import android.widget.Toast
import com.swu.doran.R
import com.swu.doran.mailbox.sent.letter.list.L_ContentsActivity
import com.swu.doran.mailbox.sent.letter.list.L_Data


class SendEmojiActivity : AppCompatActivity() {
    lateinit var m_datas: M_Data
    lateinit var img: ImageView
    lateinit var name: TextView

    lateinit var emoji1: ImageView
    lateinit var emoji2: ImageView
    lateinit var emoji3: ImageView
    lateinit var emoji4: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_emoji)

        m_datas = (intent.getSerializableExtra("data") as? M_Data?)!!
        img = findViewById(R.id.img)
        name = findViewById(R.id.name)

        Glide.with(this).load(m_datas.img).into(img)
        name.text = m_datas.name

        emoji1 = findViewById(R.id.emoji_1)
        emoji2 = findViewById(R.id.emoji_2)
        emoji3 = findViewById(R.id.emoji_3)
        emoji4 = findViewById(R.id.emoji_4)


        emoji1.setOnClickListener {
            Intent(this, L_Activity::class.java).apply {
                emoji1.isSelected = !emoji1.isSelected;
                putExtra("emoji", Emoji_Data(emoji1))
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run {
                startActivity(this)
            }

        }
        emoji2.setOnClickListener {
            Intent(this, L_Activity::class.java).apply {
                emoji2.isSelected = !emoji2.isSelected;
                putExtra("emoji", Emoji_Data(emoji2))
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run {
                startActivity(this)
            }

        }
        emoji3.setOnClickListener {
            Intent(this, L_Activity::class.java).apply {
                emoji3.isSelected = !emoji3.isSelected;
                putExtra("emoji", Emoji_Data(emoji3))
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run {
                startActivity(this)
            }

        }
        emoji4.setOnClickListener {
            Intent(this, L_Activity::class.java).apply {
                emoji4.isSelected = !emoji4.isSelected;
                putExtra("emoji", Emoji_Data(emoji4))
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run {
//                startActivity(this)
                Toast.makeText(this@SendEmojiActivity,"일단 이모지 보내기는 성공, 받기를 해야됨", Toast.LENGTH_SHORT).show()
            }

        }


    }

    fun back(view: View) {
        super.onBackPressed()
    }

    //보내기 버튼
    fun sendEmoji(view: View) {
    }


}

