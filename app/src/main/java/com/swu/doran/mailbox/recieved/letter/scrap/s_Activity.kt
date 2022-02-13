package com.swu.doran.mailbox.recieved.letter.scrap

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.letter.list.l_Activity

class s_Activity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recieved_letter_scrap)
    }

    fun listBtn(view: android.view.View) {
        startActivity(Intent(this,l_Activity::class.java))
    }
}