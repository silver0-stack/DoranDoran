package com.swu.doran.mailbox.sent.letter.list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.doran.R

class L_Adapter(private val context: Context) : RecyclerView.Adapter<L_Adapter.ViewHolder>() {

    var datas = mutableListOf<L_Data>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val img: ImageView = itemView.findViewById(R.id.img)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val date: TextView = itemView.findViewById(R.id.timesent)

        fun bind(item: L_Data) {
            Glide.with(itemView).load(item.img).into(img)
            name.text = item.name
            date.text = item.date

            //쪽지 or 감정스티커 아이템 클릭 리스너
            //move from list to contents
            //name,date 출력
            itemView.setOnClickListener {
                Intent(context, L_ContentsActivity::class.java).apply {
                    putExtra("data", item)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): L_Adapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sent_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: L_Adapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int = datas.size
}