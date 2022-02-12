package com.swu.doran.password

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swu.doran.R
import com.swu.doran.SignInActivity

class EmailToSignIn:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_to_signin)

    }

    fun emailToSignIn(view: android.view.View) {
        startActivity(Intent(this,SignInActivity::class.java))
    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }
}