package com.swu.doran.profile.edit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R
import com.swu.doran.profile.start.ProfileAdapter
import com.swu.doran.profile.start.ProfileData
import com.swu.doran.profile.start.ProfileMenuActivity

/*아이템 수정하는 액티비티*/
class ProfileEditActivity : ProfileMenuActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)
    }
    /*
    lateinit var profileName: EditText
    lateinit var completeProfileEdit: TextView
    lateinit var clear: ImageView




        clear = findViewById(R.id.clear)
        completeProfileEdit = findViewById(R.id.completeProfileEdit)
        profileName = findViewById(R.id.profileName)
        val layout= LinearLayoutManager(this)
        profile_rv.layoutManager=layout
        profile_rv.setHasFixedSize(true)

        val profileName = profileName.text.toString().trim()


        //x표시 메소드
        clear.setOnClickListener {
            adapter.removeItem(clickcount)
           startActivity(Intent(this,ProfileMenuActivity::class.java))

        }
        //수정 완료 메소드
        completeProfileEdit.setOnClickListener {
            adapter.addItem(ProfileData("user", profileName))
            startActivity(Intent(this,ProfileMenuActivity::class.java))
        }

    }

    //프사 변경 메소드
    fun modifyPFP(view: android.view.View) {


    }


    //프로필 삭제 메솓,
    fun deleteProfile(view: android.view.View) {

    }

     */

}