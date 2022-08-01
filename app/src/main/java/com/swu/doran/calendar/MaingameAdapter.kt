package com.swu.doran.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R

class MaingameAdapter() :
    RecyclerView.Adapter<MaingameAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var gamename: TextView = itemView.findViewById(R.id.game_name)
        public var gamedate: TextView = itemView.findViewById(R.id.game_date)
        public var gametext: TextView = itemView.findViewById(R.id.game_text)
        public var gameimage1: ImageView = itemView.findViewById(R.id.game_image1)
        public var gameimage2: ImageView = itemView.findViewById(R.id.game_image2)

    }

    // 1. Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_day_card_game, parent, false)

        return MyViewHolder(cardView)
    }

    // 2. Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.gamename.setText("김지원 10키로 다이어트")
        holder.gamedate.setText("2021년 11월 1일 ~ 2021년 12월 5일")
        holder.gametext.setText("원하는 가방 하나 사주기")
        //holder.gameimage1.setImageResource(R.drawable.main_fullbtn)
        //holder.gameimage2.setImageResource(R.drawable.main_fullbtn)
    }

    // 3. Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return 3
    }
}