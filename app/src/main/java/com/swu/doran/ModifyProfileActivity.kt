package com.swu.doran

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ModifyProfileActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modify_profile)



    }
    //프사 변경 메소드
    fun modifyPFP(view: android.view.View) {


    }

    //x표 메소드
    fun clear(view: android.view.View) {
    super.onBackPressed()
    }

    //프로필 수정 완료 메소드
    fun complete_Profile_Modification(view: android.view.View) {
        startActivity(Intent(this,SelectProfileActivity::class.java))
    }

}