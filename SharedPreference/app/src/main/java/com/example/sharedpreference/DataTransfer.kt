package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DataTransfer : AppCompatActivity() {
    lateinit var details: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_transfer)
        details = findViewById(R.id.details)
        var sp = this.getSharedPreferences("sharedPrefApp", MODE_PRIVATE)
        details.text =
            "UserName: ${sp.getString("userName", null)}\nPassword: ${sp.getString("password", null)} "
    }
}