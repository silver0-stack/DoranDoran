package com.swu.doran

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class FamilyWriting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.family_writing)

        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        val familyUpdateBtn = findViewById<ImageButton>(R.id.family_update_btn)

        backBtn.setOnClickListener{
            val intent = Intent(this, MainDayActivity::class.java)
            startActivity(intent)
        }
    }
}