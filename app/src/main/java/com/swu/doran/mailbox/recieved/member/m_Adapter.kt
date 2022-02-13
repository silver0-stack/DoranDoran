package com.swu.doran.mailbox.recieved.member

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.doran.R
import com.swu.doran.mailbox.recieved.letter.list.l_Activity

class m_Adapter(private val context: Context) : RecyclerView.Adapter<m_Adapter.ViewHolder>() {

    var datas = mutableListOf<m_Data>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val img: ImageView = itemView.findViewById(R.id.img)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val accumulated:TextView=itemView.findViewById(R.id.accumulated)
        private val badge: Button = itemView.findViewById(R.id.badge)
        //
        fun bind(item: m_Data) {
            Glide.with(itemView).load(item.img).into(img)
            name.text= item.name
            accumulated.text= item.accumulated.toString()
            badge.text= item.badge

            //멤버 아이템 클릭 리스너
            //멤버데이터에서 이미지,이름,누적개수,뱃지 추출
            itemView.setOnClickListener {
                Intent(context, l_Activity::class.java).apply {
                    putExtra("data", item)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run {
                    context.startActivity(this)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): m_Adapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mailbox_member_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: m_Adapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int = datas.size
}