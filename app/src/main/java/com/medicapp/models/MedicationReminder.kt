package com.medicapp.models

data class MedicationReminder(
    val name: String,
    val time: String,   // "6:00 AM"
    val dosage: String,  // "tableta"
    val quantity: Int    // 1
    // Puedes añadir más campos: id, fecha, etc.
)