package com.swu.doran.calendar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.swu.doran.R

class MentionResultAdapter(
    private val context: Context,
    private val dataList: ArrayList<MentionResult>
) :
    RecyclerView.Adapter<MentionResultAdapter.ItemViewHolder>() {


    var mPosition = 0

    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    lateinit var profileRef: DatabaseReference

    lateinit var shared: SharedPreferences

    lateinit var img: String
    lateinit var name: String

    fun getPosition(): Int {
        return mPosition
    }

    fun setPosition(Position: Int) {
        mPosition = Position
    }


    @SuppressLint("NotifyDataSetChanged")
    public fun addItem(profiledata: MentionResult) {
        dataList.add(profiledata)
        this.notifyDataSetChanged()  //갱신처리
    }


    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(position: Int) {
        if (dataList.size != 0) {
            dataList.removeAt(position)
            this.notifyItemRemoved(position)
            this.notifyDataSetChanged() //갱신처리 반드시 해야 함
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userImg = itemView.findViewById<ImageView>(R.id.profileImg) //프사


        fun bind(profiledata: MentionResult, context: Context) {
            Log.d("dataList[mPosition]: ", dataList[mPosition].toString())
            Log.d("mPosition: ", mPosition.toString())
            Glide.with(context).load(profiledata.image).into(userImg)


        }

    }

    /*최초 view를 로딩할 때 레이아웃을 inflate 하여 viewholder 생성*/
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mention_image, parent, false)

        return ItemViewHolder(view)

    }


    /*layout의 view와 데이터 연결*/
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)


        holder.itemView.setOnClickListener {

            //setMultipleSelection(holder.adapterPosition)

//                if(isSelectedMode){
//                    if (selected.contains(dataList[holder.adapterPosition])) {
//                        holder.itemView.setBackgroundColor(Color.TRANSPARENT)
//                        selected.remove(dataList[holder.adapterPosition])
////                    if (selected.isEmpty()) {
////
////                    }
//
//                    } else {
//                        holder.itemView.setBackgroundResource(R.color.bright_yellow)
//                        selected.add(dataList[holder.adapterPosition])
//                    }
//
//                    if (selected.size == 0) isSelectedMode = false
//                }else{
//
//                }



            setPosition(position)

            Toast.makeText(context, "포지션: $position 아이템 클릭", Toast.LENGTH_SHORT)
                .show()


            shared = context.getSharedPreferences("profile_info", Context.MODE_PRIVATE)
            val edit = shared.edit()
            edit.putInt("mention_profile_number", position)
            Toast.makeText(context, "$position Was Saved", Toast.LENGTH_SHORT).show()
            edit.apply()


            //MainActivity intent
//            val intent = Intent(context, ScheduleWritingActivity::class.java)
//            intent.putExtra("profile_number", position)
//            context.startActivity(intent)


        }


    }

    //다중 선택 기능
//    private fun setMultipleSelection(adapterPosition: Int) {
//
//        //반대의 값을 넣어준다
//        if(dataList[adapterPosition].isSelected())
//    }


    override fun getItemCount(): Int {
        return dataList.size
    }

}