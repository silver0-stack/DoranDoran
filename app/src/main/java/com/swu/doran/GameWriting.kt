package com.swu.doran

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class GameWriting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_writing)

        val backBtn = findViewById<ImageButton>(R.id.backBtn)

        backBtn.setOnClickListener{
            val intent = Intent(this, MainDayActivity::class.java)
            startActivity(intent)
        }
    }
}