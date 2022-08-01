package com.swu.doran.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swu.doran.R

class MainfamilyAdapter() :
    RecyclerView.Adapter<MainfamilyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var familyname: TextView = itemView.findViewById(R.id.family_card_title)
        public var familydate: TextView = itemView.findViewById(R.id.family_date)
        public var familytext: TextView = itemView.findViewById(R.id.family_card_content)

    }

    // 1. Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_day_card_family, parent, false)

        return MyViewHolder(cardView)
    }

    // 2. Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.familyname.setText("엄마 생일파티")
        holder.familydate.setText("11월 5일 22시 48분")
        holder.familytext.setText("오늘 생일파티 진짜 꿀잼!")
    }

    // 3. Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return 3
    }
}