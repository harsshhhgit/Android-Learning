package com.example.applicationlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MyActivity", "FirstActivity onCreate")
//        val toast = Toast.makeText(this, "FirstActivity onCreate", Toast.LENGTH_SHORT)
//        toast.setGravity(Gravity.TOP, 0, 250)
//        toast.show()

        val textValueClick = findViewById<TextView>(R.id.textView)
        textValueClick.setOnClickListener{
            intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }

        val imageButtonClick = findViewById<Button>(R.id.button)
        imageButtonClick.setOnClickListener{
            intent = Intent(applicationContext, LifecycleImageActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MyActivity", "FirstActivity onStart")
//        Toast.makeText(this, "FirstActivity onStart", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Log.d("MyActivity", "FirstActivity onResume")
//        Toast.makeText(this, "FirstActivity onResume", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Log.d("MyActivity", "FirstActivity onPause")
//        Toast.makeText(this, "FirstActivity onPause", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Log.d("MyActivity", "FirstActivity onStop")
//        Toast.makeText(this, "FirstActivity onStop", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyActivity", "FirstActivity onDestroy")
//        Toast.makeText(this, "FirstActivity onDestroy", Toast.LENGTH_SHORT).show()
    }
}