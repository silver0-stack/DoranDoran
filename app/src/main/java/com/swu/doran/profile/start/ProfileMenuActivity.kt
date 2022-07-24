package com.swu.doran.profile.start

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


open class ProfileMenuActivity : AppCompatActivity() {

    lateinit var edit_profile: TextView
    lateinit var add_profile: TextView
    lateinit var recyclerv: RecyclerView
    lateinit var userData: ProfileData
    lateinit var userAdapter: ProfileAdapter
    lateinit var userList: ArrayList<ProfileData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.swu.doran.R.layout.profile_start)

        add_profile = findViewById(com.swu.doran.R.id.add_profile)
        edit_profile = findViewById(com.swu.doran.R.id.edit_profile)

        recyclerv = findViewById(com.swu.doran.R.id.profile_rv)

        userList=ArrayList()
        userAdapter=ProfileAdapter(this,userList)
        recyclerv.adapter=userAdapter

        val gridLayoutManager = GridLayoutManager(applicationContext, 3)
        recyclerv.layoutManager = gridLayoutManager
        recyclerv.setHasFixedSize(true)

        val icon = BitmapFactory.decodeResource(resources, com.swu.doran.R.drawable.user)

        var i=-1

        /*프로필 추가 이벤트*/
        add_profile.setOnClickListener {
            i++
            userAdapter.addItem(ProfileData(icon.toString(),"user$i"))
        }


        /*프로필 편집 이벤트*/
        edit_profile.setOnClickListener {

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
}