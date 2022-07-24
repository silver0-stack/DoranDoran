package com.swu.doran.profile.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swu.doran.R
import android.content.Intent
import android.view.View
import com.swu.doran.profile.add.Profile_birthday
import com.swu.doran.profile.add.Profile_select_emoji

class Profile_emoji : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_emoji)
    }

    fun next(view: View?) {
        startActivity(Intent(this, Profile_birthday::class.java))
    }

    fun back(view: View?) {
        super.onBackPressed()
    }

    //프사 선택
    fun selectImg(view: View?) {
        startActivity(Intent(this, Profile_select_emoji::class.java))
    }
}