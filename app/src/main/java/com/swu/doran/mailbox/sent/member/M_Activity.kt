package com.swu.doran.mailbox.sent.member

import androidx.appcompat.app.AppCompatActivity

class M_Activity:AppCompatActivity() {
//    lateinit var recyclerview: RecyclerView
//    private lateinit var adapter: M_Adapter //adapter 객체 먼저 선언해주기!
//    private var layoutmanager: RecyclerView.LayoutManager? = null
//
//    val M_datas = mutableListOf<M_Data>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.sent_mailbox)
//
//        recyclerview = findViewById(R.id.sent_member)
//        initRecycler()
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    private fun initRecycler() {
//        adapter = M_Adapter(this)
//        layoutmanager= LinearLayoutManager(this)
//        recyclerview.setHasFixedSize(true)
//        recyclerview.layoutManager=layoutmanager
//        recyclerview.adapter = adapter
//
//
//        M_datas.apply {
//            add(M_Data(img = R.drawable.mom01, name = "엄마", accumulated = 0))
//            add(M_Data(img = R.drawable.dad01, name = "아빠", accumulated = 0))
//            add(M_Data(img = R.drawable.girl_10s_02, name = "언니", accumulated = 0))
//            adapter.datas =  M_datas
//            adapter.notifyDataSetChanged()
//        }
//    }
//
//    fun back(view: android.view.View) {
//        super.onBackPressed()
//    }
//    //스크랩버튼
//    fun toScrap(view: android.view.View) {
//
//    }
//    fun toReceivedLetter(view: android.view.View) {
//        startActivity(Intent(this,m_Activity::class.java))
//    }
}