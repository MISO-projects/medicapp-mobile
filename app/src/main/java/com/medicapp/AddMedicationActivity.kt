package com.medicapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar

class AddMedicationActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var btnChatBot: Button
    private lateinit var etMedicamento: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medication)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btnChatBot = findViewById(R.id.btnChatBot)
        etMedicamento = findViewById(R.id.etMedicamento)

        val spPresentacion = findViewById<AutoCompleteTextView>(R.id.spPresentacion)
        val presentaciones = listOf("Tableta", "Cápsula", "Jarabe", "Inyección")
        val adapterPresentacion = ArrayAdapter(this, android.R.layout.simple_list_item_1, presentaciones)
        spPresentacion.setAdapter(adapterPresentacion)

        val spPeriodicidad = findViewById<AutoCompleteTextView>(R.id.spPeriodicidad)
        val periodicidades = listOf("Cada 8 horas", "Cada 12 horas", "Cada 24 horas")
        val adapterPeriodicidad = ArrayAdapter(this, android.R.layout.simple_list_item_1, periodicidades)
        spPeriodicidad.setAdapter(adapterPeriodicidad)

        val tilFechaInicio = findViewById<TextInputLayout>(R.id.tilFechaInicio)
        val etFechaInicio = findViewById<TextInputEditText>(R.id.etFechaInicio)

        tilFechaInicio.setEndIconOnClickListener {
            // Obtén la fecha actual como predeterminada
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // Crea el DatePickerDialog
            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                // Formatea la fecha, recuerda que los meses inician en 0
                val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                etFechaInicio.setText(formattedDate)
            }, year, month, day)

            // Muestra el diálogo
            datePickerDialog.show()
        }

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        btnAgregar.setOnClickListener {
        }
    }
}