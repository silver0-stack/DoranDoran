package com.swu.doran.profile.start

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
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
        notifyDataSetChanged()  //갱신처리
    }


    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(position: Int) {
        if (position > 0) {
            dataList.removeAt(position)
            notifyDataSetChanged() //갱신처리 반드시 해야 함
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userImg = itemView.findViewById<ImageView>(R.id.profileImg) //프사
        private val userName = itemView.findViewById<TextView>(R.id.profileName) //프로필네임

        fun bind(profiledata: ProfileData, context: Context) {
            if (profiledata.profile_img != "") {
                val resourceId =
                    context.resources.getIdentifier(
                        profiledata.profile_img,
                        "drawable",
                        context.packageName
                    )
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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.profile_item, parent, false)
        return ItemViewHolder(view)

    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
        holder.itemView.setOnClickListener { view ->
            setPosition(position)
            Toast.makeText(view.context, "$position 아이템 클릭!", Toast.LENGTH_SHORT)
                .show()
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

}