package com.swu.doran.mailbox.sent.letter.list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.send.SendActivity
import com.swu.doran.mailbox.sent.member.M_Data

class L_Activity_O:AppCompatActivity(){
    lateinit var datas: M_Data
    //    lateinit var emoji_data: Emoji_Data
    lateinit var img: ImageView
    lateinit var name: TextView
    lateinit var accumulated: TextView
    lateinit var recyclerview: RecyclerView
    private lateinit var adapter: L_Adapter //adapter 객체 먼저 선언해주기!
    private var layoutmanager: RecyclerView.LayoutManager? = null
    val L_datas = mutableListOf<L_Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sent_letter_list_o)

        adapter = L_Adapter(this)
        datas = (intent.getSerializableExtra("data") as? M_Data?)!!
//        emoji_data = (intent.getSerializableExtra("emoji") as? Emoji_Data?)!!
        img = findViewById(R.id.img)
        name = findViewById(R.id.name)
        accumulated = findViewById(R.id.accumulated)

        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name
        accumulated.text = datas.accumulated.toString()

        recyclerview = findViewById(R.id.sent_letter_list)
        initRecycler()


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler() {
        layoutmanager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = layoutmanager
        recyclerview.adapter = adapter


        L_datas.apply {
            val selected = intent.getIntExtra("emoji", 0);
//           when(selected){
//               1->
//                mHomeButton.setImageResource(R.drawable.blue);
//
//                case 2 ... and so on
//            }
            add(
                L_Data(
                    img = datas.img,
                    name = name.text.toString() + " 님께 이모티콘으로 감정을 표현했어요",
                    date = "2022.01.12"
                )
            )
            add(
                L_Data(
                    img = R.drawable.unread_letter,
                    name = name.text.toString() + " 님께 편지를 보냈어요",
                    date = "2022.01.22"
                )
            )
            add(
                L_Data(
                    img = R.drawable.read_letter,
                    name = name.text.toString() + " 님께 편지를 보냈어요",
                    date = "2022.02.12"
                )
            )
            adapter.datas = L_datas
            adapter.notifyDataSetChanged()
        }
    }

    fun sendLetter(view: android.view.View) {
        Intent(this, SendActivity::class.java).apply {
            putExtra("data", datas)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run { startActivity(this) }
    }

}