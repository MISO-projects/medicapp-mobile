package com.medicapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medicapp.R
import com.medicapp.models.DayItem

class DayAdapter(
    private val dayList: List<DayItem>
) : RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    private var selectedPosition = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val dayItem = dayList[position]
        holder.bind(dayItem, position == selectedPosition)

        holder.itemView.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener

            val oldPosition = selectedPosition
            selectedPosition = adapterPosition
            if (oldPosition != RecyclerView.NO_POSITION) {
                notifyItemChanged(oldPosition)
            }
            notifyItemChanged(adapterPosition)
        }
    }

    override fun getItemCount(): Int = dayList.size

    class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val container: View = itemView.findViewById(R.id.dayItemContainer)
        private val tvDayLabel: TextView = itemView.findViewById(R.id.tvDayLabel)

        fun bind(dayItem: DayItem, isSelected: Boolean) {
            tvDayLabel.text = dayItem.label
            val backgroundRes = if (isSelected)
                R.drawable.bg_day_item_selected
            else
                R.drawable.bg_day_item
            container.setBackgroundResource(backgroundRes)
        }
    }
}
