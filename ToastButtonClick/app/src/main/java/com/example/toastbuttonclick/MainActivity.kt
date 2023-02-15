package com.example.toastbuttonclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastButton = findViewById<Button>(R.id.toastButton)

        toastButton.setOnClickListener {
            Toast.makeText(applicationContext, "Displaying Toast...", Toast.LENGTH_SHORT).show()
        }
    }
}