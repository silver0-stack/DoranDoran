package com.swu.doran.profile.start

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R
import com.swu.doran.SignInActivity
import com.swu.doran.profile.add.Profile_name
import com.swu.doran.profile.edit.ProfileEditActivity
import com.swu.doran.profile.edit.ProfileSelectActivity


open class ProfileMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_start)

        val profile_add = findViewById<ImageView>(R.id.profile_add)
        profile_add.setOnClickListener{
            val intent= Intent(this, Profile_name::class.java)
            startActivity(intent)
        }
    }
    /*
    lateinit var inflater: LayoutInflater
    lateinit var view: View
    lateinit var addProfile: TextView
    lateinit var profile_rv:RecyclerView
    lateinit var EditProfile:TextView
    lateinit var mContext:Context
    var list= ArrayList<ProfileData>()
    var clickcount=-1
    val adapter= ProfileAdapter(this,list)




        list = ArrayList()
        //addProfile=findViewById(R.id.addProfile)
       // profile_rv=findViewById(R.id.profile_rv)
       // EditProfile=findViewById(R.id.EditProfile)

        profile_rv.adapter=adapter
        val layout=LinearLayoutManager(this)
        profile_rv.layoutManager=layout
        profile_rv.setHasFixedSize(true)



        //프로필 추가 리스너
        addProfile.setOnClickListener {it->
            clickcount += 1;
            if(clickcount==1)
            {
                //first time clicked to do this
                Toast.makeText(applicationContext,"Button clicked first time!", Toast.LENGTH_LONG).show();
            }
            else
            {
                //check how many times clicked and so on
                Toast.makeText(applicationContext, "Button clicked count is$clickcount", Toast.LENGTH_LONG).show();
            }
            startActivity(Intent(this, ProfileEditActivity::class.java))

        }
        //프로필 수정 리스너
        EditProfile.setOnClickListener{
            startActivity(Intent(this,ProfileSelectActivity::class.java))

        }
    }
    */


}