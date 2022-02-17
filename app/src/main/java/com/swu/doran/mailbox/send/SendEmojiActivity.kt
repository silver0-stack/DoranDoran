package com.swu.doran.mailbox.send

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.sent.letter.list.L_Activity
import com.swu.doran.mailbox.sent.member.M_Data
import android.graphics.Bitmap

import android.graphics.drawable.BitmapDrawable
import android.widget.Switch
import java.io.ByteArrayOutputStream
import com.swu.doran.MainActivity





class SendEmojiActivity : AppCompatActivity() {
    lateinit var datas: M_Data
    lateinit var img: ImageView
    lateinit var name: TextView

    lateinit var emoji1:ImageView
    lateinit var emoji2:ImageView
    lateinit var emoji3:ImageView
    lateinit var emoji4:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_emoji)

        datas = (intent.getSerializableExtra("data") as? M_Data?)!!
        img = findViewById(R.id.img)
        name = findViewById(R.id.name)

        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name

        var intent=Intent(this,L_Activity::class.java)
        emoji1=findViewById(R.id.emoji_1)
        emoji2=findViewById(R.id.emoji_2)
        emoji3=findViewById(R.id.emoji_3)
        emoji4=findViewById(R.id.emoji_4)


    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }

    //보내기버튼
    fun sendEmoji(view: android.view.View) {
        intent.putExtra("image", byteArray);
        if(emoji1.click)
    }

    //TODO 이모지 리사이클러뷰(horizontal)로 설정하고 imageview serializable 로 putextra 하기
    //이모지1 클릭이벤트
    fun send_emoji(view: android.view.View) {

        if (view==emoji1) {
            view.setBackgroundColor(Color.parseColor("#4B000000"))
            val stream = ByteArrayOutputStream()
            val bitmap = (emoji1.drawable as BitmapDrawable).bitmap
            val scale = (1024 / bitmap.width.toFloat())
            val image_w = (bitmap.width * scale).toInt()
            val image_h = (bitmap.height * scale).toInt()
            val resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true)
            resize.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()
            val intent = Intent(this, L_Activity::class.java)
            intent.putExtra("image", byteArray);



        } else if (view==emoji2) {
            view.setBackgroundColor(Color.parseColor("#4B000000"))
        } else if (view==emoji3) {
            view.setBackgroundColor(Color.parseColor("#4B000000"))
        } else {
            view.setBackgroundColor(Color.parseColor("#4B000000"))
        }


    }

}