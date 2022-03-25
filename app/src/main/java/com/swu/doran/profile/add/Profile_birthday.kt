package com.swu.doran.profile.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swu.doran.R
import android.content.Intent
import android.graphics.Color
import android.view.TextureView
import android.view.View
import android.widget.TextView
import com.swu.doran.profile.start.ProfileMenuActivity

class Profile_birthday : AppCompatActivity() {
    lateinit var lunar: TextView
    lateinit var solar: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_birthday)

        lunar = findViewById(R.id.Lunar)
        solar = findViewById(R.id.Solar)
    }

    fun back(view: View?) {
        super.onBackPressed()
    }

    //프로필 설정 완료 버튼
    fun complete(view: View?) {
        startActivity(Intent(this, ProfileMenuActivity::class.java))
    }

    fun LunarOrSolar(view: View?) {
        if (view != null) {
            when (view.id) {
                //음력 클릭
                R.id.Lunar -> {
                    lunar.setTextColor(Color.parseColor("#F5C364"))
                    solar.setTextColor(Color.parseColor("#737171"))
                }

                //양력 클릭
                R.id.Solar -> {
                    lunar.setTextColor(Color.parseColor("#737171"))
                    solar.setTextColor(Color.parseColor("#F5C364"))

                }
            }
        }
    }
}