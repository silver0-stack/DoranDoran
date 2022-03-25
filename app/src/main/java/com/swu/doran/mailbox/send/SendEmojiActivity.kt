package com.swu.doran.mailbox.send

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.mailbox.sent.member.M_Data
import android.view.View
import android.widget.Toast
import com.swu.doran.R
import com.swu.doran.mailbox.sent.letter.list.L_ContentsActivity


class SendEmojiActivity : AppCompatActivity() {
    lateinit var m_datas: M_Data
    lateinit var img: ImageView
    lateinit var name: TextView

    lateinit var emoji1: ImageView
    lateinit var emoji2: ImageView
    lateinit var emoji3: ImageView
    lateinit var emoji4: ImageView
    lateinit var emoji5: ImageView
    lateinit var emoji6: ImageView
    lateinit var emoji7: ImageView
    lateinit var emoji8: ImageView
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

    }

    fun back(view: View) {
        super.onBackPressed()
    }

    //보내기 버튼
    fun sendEmoji(view: View) {

    }

    fun send_emoji(view: View) {
        view.setOnClickListener {
            Intent(this, L_ContentsActivity::class.java).apply {
                view.isSelected = !view.isSelected;
                putExtra("emoji", Emoji_Data(view as ImageView))
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run {
//                startActivity(this)
                Toast.makeText(this@SendEmojiActivity,"${view.accessibilityClassName} 클릭", Toast.LENGTH_SHORT).show()
            }

        }
    }


}

