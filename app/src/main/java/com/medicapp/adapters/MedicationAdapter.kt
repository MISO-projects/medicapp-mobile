package com.medicapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medicapp.R
import com.medicapp.models.MedicationReminder

class MedicationAdapter(
    private val reminders: List<MedicationReminder>
) : RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medication_reminder, parent, false)
        return MedicationViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        holder.bind(reminders[position])
    }

    override fun getItemCount(): Int = reminders.size

    class MedicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivIcon: ImageView = itemView.findViewById(R.id.ivIcon)
        private val tvMedicationName: TextView = itemView.findViewById(R.id.tvMedicationName)
        private val tvMedicationInfo: TextView = itemView.findViewById(R.id.tvMedicationInfo)
        private val tvMedicationType: TextView = itemView.findViewById(R.id.tvMedicationType)

        fun bind(reminder: MedicationReminder) {
            tvMedicationName.text = reminder.name
            tvMedicationInfo.text = reminder.time
            tvMedicationType.text = "${reminder.dosage} ${reminder.quantity}"

            if(reminder.dosage.equals("tableta", ignoreCase = true)) {
                ivIcon.setImageResource(R.drawable.ic_pill)
            } else {
                ivIcon.setImageResource(R.drawable.ic_capsule)
            }
        }
    }
}
