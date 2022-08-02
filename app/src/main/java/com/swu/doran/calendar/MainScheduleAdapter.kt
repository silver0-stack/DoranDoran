package com.swu.doran.calendar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R

class MainScheduleAdapter() :
    RecyclerView.Adapter<MainScheduleAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dayname: TextView = itemView.findViewById(R.id.day_name)
        var daydate: TextView = itemView.findViewById(R.id.day_date)
        var daylocation: TextView = itemView.findViewById(R.id.day_location)
        var dayimage1: ImageView = itemView.findViewById(R.id.day_image1)
        var dayimage2: ImageView = itemView.findViewById(R.id.day_image2)

    }

    // 1. Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_day_card_schedule, parent, false)

        return MyViewHolder(cardView)
    }

    // 2. Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.dayname.text = "엄마 생일파티"
        holder.daydate.text = "[11월 5일] 17시 ~ 19시"
        holder.daylocation.text = "자연별곡 용산점"
        //holder.dayimage1.setImageResource(R.drawable.main_fullbtn)
        //holder.dayimage2.setImageResource(R.drawable.main_fullbtn)
    }

    // 3. Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return 3
    }
}