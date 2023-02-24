package com.example.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentlifecycle.fragment.AFragment
import com.example.fragmentlifecycle.fragment.BFragment
import com.example.fragmentlifecycle.fragment.CFragment

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fm : FragmentManager = supportFragmentManager
        var ft : FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.container, AFragment())
        ft.commit()

        val container = findViewById<FrameLayout>(R.id.container)
        btn1 = findViewById(R.id.btnFrag1)
        btn2 = findViewById(R.id.btnFrag2)
        btn3 = findViewById(R.id.btnFrag3)

        btn1.setOnClickListener {
            fragLoader(AFragment())
        }
        btn2.setOnClickListener {
            fragLoader(BFragment())
        }
        btn3.setOnClickListener {
            fragLoader(CFragment())
        }

    }
    private fun fragLoader(fragment : Fragment){
        var fm : FragmentManager = supportFragmentManager
        var ft : FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
    }
}