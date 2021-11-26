package com.swu.doran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SelectProfileActivity : AppCompatActivity() {
    lateinit var inflater: LayoutInflater
    lateinit var view: View
    lateinit var addProfile: Button
    lateinit var profile_rv:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_select)

        val list = ArrayList<ProfileData>()
        val adapter=ProfileRVAdapter(this,list)
        addProfile=findViewById(R.id.addProfile)
        profile_rv=findViewById(R.id.profile_rv)

        profile_rv.adapter=adapter
        val layout=LinearLayoutManager(this)
        profile_rv.layoutManager=layout
        profile_rv.setHasFixedSize(true)


        //프로필 추가 리스너
        addProfile.setOnClickListener {
            adapter.addItem(ProfileData("user","User"))

//            inflater = layoutInflater
//            view = inflater.inflate(R.layout.profile_item, null)
//
//            val profileItem: LinearLayout = view.findViewById(R.id.eachPFItem)
//            profileItem.visibility = View.VISIBLE
//            profileItem.layoutParams=
//                RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }


    }

    //프로필 수정 메소드
    fun modifyProfile(view: View) {
       // startActivity(Intent(this, ModifyProfileActivity::class.java))
    }
}