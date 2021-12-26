package com.swu.doran

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OnBoardingActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)


    }

    fun signIn(view: android.view.View) {
        val intent= Intent(this,SignInActivity::class.java)
        startActivity(intent)
    }
    fun signUp(view: android.view.View) {
        val intent= Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }
}