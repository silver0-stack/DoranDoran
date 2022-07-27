package com.swu.doran.mailbox.recieved.member

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.swu.doran.R
import com.swu.doran.mailbox.sent.member.sentMemberData

class SentMemberAdapter(private val context: Context, private val dataList: ArrayList<sentMemberData>) :
    RecyclerView.Adapter<SentMemberAdapter.ItemViewHolder>() {

    var mPosition = 0

    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    lateinit var profileRef: DatabaseReference

    lateinit var shared : SharedPreferences

    lateinit var img: String
    lateinit var name: String

    fun getPosition(): Int {
        return mPosition
    }

    fun setPosition(Position: Int) {
        mPosition = Position
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userImg = itemView.findViewById<ImageView>(R.id.img) //프사
        private val userName = itemView.findViewById<TextView>(R.id.name) //프로필네임
        private val accumulated = itemView.findViewById<TextView>(R.id.accumulated) //알림


        @SuppressLint("SetTextI18n")
        fun bind(memberData: sentMemberData, context: Context) {
//            Log.d("dataList[mPosition]: ", dataList[mPosition].toString())
//            Log.d("mPosition: ", mPosition.toString())

            Glide.with(context).load(memberData.img).into(userImg)
            userName.text =memberData.name
            accumulated.text= memberData.total.toString()

        }

    }

    /*최초 view를 로딩할 때 레이아웃을 inflate 하여 viewholder 생성*/
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):SentMemberAdapter.ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sent_member_item, parent, false)
        return ItemViewHolder(view)

    }


    /*layout의 view와 데이터 연결*/
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position],context)

        //프로필 클릭 이벤트
        holder.itemView.setOnClickListener { view ->
            setPosition(position)
            Toast.makeText(view.context, "포지션: $position 아이템 클릭", Toast.LENGTH_SHORT)
                .show()


//            shared = context.getSharedPreferences("profile_info" , Context.MODE_PRIVATE)
//            val edit = shared.edit()
//            edit.putInt("profile_number" , position)
//            Toast.makeText(context , "$position Was Saved" , Toast.LENGTH_SHORT).show()
//            edit.apply()


            //MainActivity intent
//            val intent = Intent(context, MainActivity::class.java)
//            intent.putExtra("profile_number",position)
//            context.startActivity(intent)
        }


        //val builder = AlertDialog.Builder(context)


//        //프로필 길게 클릭 이벤트
//        holder.itemView.setOnLongClickListener {
//            setPosition(position)
//
//            //Alert Dialog show
//            builder.setTitle("프로필 삭제")
//                .setMessage("${dataList[position].profile_name} 프로필을 삭제하시겠습니까?")
//                .setPositiveButton("삭제하기") { dialogInterface: DialogInterface?, i: Int ->
//                    removeItem(position)
//                    this.notifyDataSetChanged();
//                }.setNeutralButton("취소", null)
//                .show()
//
//
//            return@setOnLongClickListener true
//        }


    }


    override fun getItemCount(): Int {
        return dataList.size
    }

}