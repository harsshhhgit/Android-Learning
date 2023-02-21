package com.example.allkotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import android.widget.ToggleButton

class ToggleBtnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_btn)

//        val toggleSwitch = findViewById<ToggleButton>(R.id.toggleButton)
        val toggleSwitch = findViewById<Switch>(R.id.toggleSwitch)
        val changingImage = findViewById<ImageView>(R.id.changingimage)

        toggleSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                changingImage.setImageResource(R.drawable.bulbon)
                toggleSwitch.text = "Turn OFF"
                Toast.makeText(applicationContext, "Bulb is turned ON", Toast.LENGTH_SHORT).show()
            }else{
                changingImage.setImageResource(R.drawable.bulboff)
                toggleSwitch.text = "Turn ON"
                Toast.makeText(applicationContext, "Bulb is turned OFF", Toast.LENGTH_SHORT).show()
            }
        }
    }
}