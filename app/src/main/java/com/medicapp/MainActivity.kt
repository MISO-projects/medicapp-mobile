package com.medicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.medicapp.adapters.DayAdapter
import com.medicapp.adapters.MedicationAdapter
import com.medicapp.models.DayItem
import com.medicapp.models.MedicationReminder

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var daysRecyclerView: RecyclerView
    private lateinit var medicationsRecyclerView: RecyclerView
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        daysRecyclerView = findViewById(R.id.daysRecyclerView)
        medicationsRecyclerView = findViewById(R.id.medicationsRecyclerView)
        bottomNav = findViewById(R.id.bottomNav)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Hoy: 8 de Abril"

        val dayItems = listOf(
            DayItem("mar\n5"), DayItem("mie\n6"), DayItem("jue\n7"),
            DayItem("vie\n8"), DayItem("sab\n9"), DayItem("dom\n10"),
            DayItem("lun\n11")
        )

        daysRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        daysRecyclerView.adapter = DayAdapter(dayItems)

        val medicationList = listOf(
            MedicationReminder("Ibuprofeno", "6:00 AM", "tableta",1),
            MedicationReminder("Ibuprofeno", "6:00 PM", "tableta",1),
            MedicationReminder("Medicamento", "9:00 AM", "píldora",1)
        )

        medicationsRecyclerView.layoutManager = LinearLayoutManager(this)
        medicationsRecyclerView.adapter = MedicationAdapter(medicationList)

        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    true
                }
                R.id.action_add -> {
                    true
                }
                R.id.action_profile -> {
                    true
                }
                else -> false
            }
        }
    }
}