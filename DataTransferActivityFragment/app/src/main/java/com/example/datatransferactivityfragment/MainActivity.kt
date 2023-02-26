package com.example.datatransferactivityfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    lateinit var data: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = findViewById(R.id.enteredValues)

        var fm : FragmentManager = supportFragmentManager
        var ft : FragmentTransaction = fm.beginTransaction()
        var frag2Activity = Frag2ActivityFragment()
        var frag2Frag = Fragment2Fragment()

        ft.add(R.id.frameLayout, frag2Activity)
        ft.add(R.id.frameLayoutfrag2, frag2Frag)
        ft.commit()

    }

    fun takeData(firstName: String, lastName: String){
        data.text = "Full Name: " + firstName.toString() + " " + lastName.toString()
    }
}