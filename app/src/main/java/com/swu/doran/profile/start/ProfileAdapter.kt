package com.swu.doran.profile.start

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.swu.d.Profile_name
import com.swu.doran.R

class ProfileAdapter(private val context: Context, private val dataList: ArrayList<ProfileData>) :
    RecyclerView.Adapter<ProfileAdapter.ItemViewHolder>() {

    var mPosition = 0

    fun getPosition(): Int {
        return mPosition
    }

    fun setPosition(Position: Int) {
        mPosition = Position
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addItem(profiledata: ProfileData) {
        dataList.add(profiledata)
        this.notifyDataSetChanged()  //갱신처리
    }


    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(position: Int) {
        if (dataList.size!=0) {
            dataList.removeAt(position)
            this.notifyItemRemoved(position)
            this.notifyDataSetChanged() //갱신처리 반드시 해야 함
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userImg = itemView.findViewById<ImageView>(R.id.profileImg) //프사
        private val userName = itemView.findViewById<TextView>(R.id.profileName) //프로필네임

        fun bind(profiledata: ProfileData, context: Context) {
            if (profiledata.profile_img != "") {
                val resourceId = context.resources.getIdentifier(profiledata.profile_img, "drawable", context.packageName)

                if (resourceId > 0) {
                    userImg.setImageResource(R.drawable.user)

                }
            } else {
                userImg.setImageResource(R.drawable.user)
            }

            //TextView에 데이터 세팅
            userName.text = profiledata.profile_name
        }

    }

    /*최초 view를 로딩할 때 레이아웃을 inflate 하여 viewholder 생성*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.profile_item, parent, false)
        return ItemViewHolder(view)

    }


    /*layout의 view와 데이터 연결*/
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)

        //프로필 클릭 이벤트
        holder.itemView.setOnClickListener { view ->
            setPosition(position)
            Toast.makeText(view.context, "포지션: $position 아이템 클릭", Toast.LENGTH_SHORT)
                .show()

            //프로필 설정 액티비티 intent
            val intent = Intent(context, Profile_name::class.java)
            intent.putExtra("user_number", position)
            context.startActivity(intent)
        }


        val builder = AlertDialog.Builder(context)


        //프로필 길게 클릭 이벤트
        holder.itemView.setOnLongClickListener {
            setPosition(position)

            //Alert Dialog show
            builder.setTitle("프로필 삭제").setMessage("${dataList[position].profile_name} 프로필을 삭제하시겠습니까?")
                .setPositiveButton("삭제하기") { dialogInterface: DialogInterface?, i: Int ->
                    removeItem(position)
                    this.notifyDataSetChanged();
                }.setNeutralButton("취소", null)
                .show()


            return@setOnLongClickListener true
        }


    }


    override fun getItemCount(): Int {
        return dataList.size
    }

}