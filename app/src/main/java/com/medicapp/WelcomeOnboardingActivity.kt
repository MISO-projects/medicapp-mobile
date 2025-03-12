package com.medicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WelcomeOnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_onboarding)

        val nextButton = findViewById<Button>(R.id.button_next)
        nextButton.setOnClickListener {
            startActivity(Intent(this, DescriptionOnboardingActivity::class.java))
        }
        val textViewSkip = findViewById<TextView>(R.id.textView_skip)
        textViewSkip.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}