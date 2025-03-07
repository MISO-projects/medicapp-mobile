package com.medicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationOnboarding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation_onboarding)
        val textViewSkip = findViewById<Button>(R.id.button_continue)
        textViewSkip.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}