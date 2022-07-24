package com.swu.doran.profile.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swu.doran.R
import android.content.Intent
import android.view.View
import com.swu.doran.profile.add.Profile_emoji

class Profile_select_emoji : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_select_emoji)
    }

    fun next(view: View?) {
        startActivity(Intent(this, Profile_emoji::class.java))
    }

    fun back(view: View?) {
        super.onBackPressed()
    }
}