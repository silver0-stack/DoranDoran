package com.swu.doran.mailbox.recieved.member

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.swu.doran.R

class MailboxActivity : AppCompatActivity(), View.OnClickListener {
//    lateinit var recyclerview: RecyclerView
//    private lateinit var adapter: m_Adapter //adapter 객체 먼저 선언해주기!
//    private var layoutmanager: RecyclerView.LayoutManager? = null

    //val m_datas = mutableListOf<m_Data>()

    lateinit var sent_letter_btn: ToggleButton
    lateinit var received_letter_btn: ToggleButton
    lateinit var receivedMember:Fragment
    lateinit var sentMember:Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mailbox)

        sent_letter_btn = findViewById(R.id.sent_letter_btn)
        received_letter_btn = findViewById(R.id.received_letter_btn)

        receivedMember=MailboxReceivedMember()
        sentMember=MailboxSentMember()

        //디폴트로 받은 편지함이 설정되도록
        supportFragmentManager.beginTransaction().replace(R.id.mailbox_frag, receivedMember)
            .commitAllowingStateLoss()

        sent_letter_btn.setOnClickListener(this)
        received_letter_btn.setOnClickListener(this)



        //  recyclerview = findViewById(R.id.received_member)
        //initRecycler()
    }

//    @SuppressLint("NotifyDataSetChanged")
//    private fun initRecycler() {
//        adapter = m_Adapter(this)
//        layoutmanager=LinearLayoutManager(this)
//        recyclerview.setHasFixedSize(true)
//        recyclerview.layoutManager=layoutmanager
//        recyclerview.adapter = adapter
//
//
//        m_datas.apply {
//            add(m_Data(img = R.drawable.mom01, name = "엄마", accumulated = 2, badge = "0"))
//            add(m_Data(img = R.drawable.dad01, name = "아빠", accumulated = 3, badge = "+ 5"))
//            add(m_Data(img = R.drawable.girl_10s_02, name = "언니", accumulated = 5, badge = "+ 3"))
//            adapter.datas =  m_datas
//            adapter.notifyDataSetChanged()
//        }
//    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v){
                sent_letter_btn->if(sent_letter_btn.isChecked){
                    sent_letter_btn.isChecked=true
                  //  sent_letter_btn.background = resources.getDrawable(R.drawable.button_bg)

                    received_letter_btn.isChecked=false


                    //보낸편지함 멤버 프래그먼트 이동
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mailbox_frag, sentMember).commitAllowingStateLoss()
                    Toast.makeText(applicationContext, "보낸 편지함 이동", Toast.LENGTH_SHORT).show()

                }else{
                    sent_letter_btn.isChecked=false
                   // sent_letter_btn.background = resources.getDrawable(0)
                }

                received_letter_btn->if(received_letter_btn.isChecked) {
                    received_letter_btn.isChecked = true
                  //  received_letter_btn.background = resources.getDrawable(R.drawable.button_bg)

                    sent_letter_btn.isChecked = false

                    //받은편지함 멤버 프래그먼트 이동
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mailbox_frag, receivedMember).commitAllowingStateLoss()

                    Toast.makeText(applicationContext, "받은 편지함 이동", Toast.LENGTH_SHORT).show()
                }else{
                    received_letter_btn.isChecked=false
                   // received_letter_btn.background = resources.getDrawable(0)
                }
            }
        }
    }

    //프래그먼트 전환
    fun onFragmentChange(index: Int) {
//        if (index == 0) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, fragment_study)
//                .addToBackStack(null).commit()
//        } else if (index == 1) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, fragment_exercise)
//                .addToBackStack(null).commit()
//        } else if (index == 2) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, fragment_hobby)
//                .addToBackStack(null).commit()
//        } else if (index == 3) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, fragment_routin)
//                .addToBackStack(null).commit()
//        } else if (index == 4) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, SearchCategory)
//                .addToBackStack(null).commit()
//        } else if (index == 5) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, setup)
//                .addToBackStack(null).commit()
//        } else if (index == 6) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, setup_profile_img)
//                .addToBackStack(null).commit()
//        } else if (index == 7) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, fragment_nofi)
//                .addToBackStack(null).commit()
//        } else if (index == 8) {
//            supportFragmentManager.beginTransaction().replace(R.id.group_layout, setup_name)
//                .addToBackStack(null).commit()
//        }
    }
    //보낸편지함버튼
//    fun toSentLetter(view: android.view.View) {
//        startActivity(Intent(this, M_Activity::class.java))
//    }
}