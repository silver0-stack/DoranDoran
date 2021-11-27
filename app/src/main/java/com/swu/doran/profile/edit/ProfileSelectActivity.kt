package com.swu.doran.profile.edit

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R
import com.swu.doran.profile.start.ProfileAdapter
import com.swu.doran.profile.start.ProfileData
import com.swu.doran.profile.start.ProfileMenuActivity

/*수정할 아이템 고르는 액티비티*/
class ProfileSelectActivity:AppCompatActivity() {
    lateinit var inflater: LayoutInflater
    lateinit var view: View
    lateinit var backToMenu: TextView
    lateinit var pf_select_rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_select)

        val list = ArrayList<ProfileData>()
        val adapter= ProfileAdapter(this,list)
        val layout= LinearLayoutManager(this)

        backToMenu=findViewById(R.id.backToMenu)
        pf_select_rv=findViewById(R.id.pf_select_rv)

        pf_select_rv.adapter=adapter
        pf_select_rv.layoutManager=layout
        pf_select_rv.setHasFixedSize(true)



    }

    //수정할 거 다하고 프로필메뉴로 돌아가는 완료 버튼(반영이 돼야 하는데..)
    fun backToMenu(view: View) {
        startActivity(Intent(this, ProfileMenuActivity::class.java))
    }
}