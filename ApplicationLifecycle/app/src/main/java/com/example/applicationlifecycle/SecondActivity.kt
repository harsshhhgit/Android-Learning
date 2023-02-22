package com.example.applicationlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("MyActivity", "SecondActivity onCreate")
        Toast.makeText(this, "SecondActivity onCreate", Toast.LENGTH_SHORT).show()
        val textValueClick1 = findViewById<TextView>(R.id.textView1)
        textValueClick1.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        val thirdActBtn = findViewById<Button>(R.id.button2)
        thirdActBtn.setOnClickListener{
            intent = Intent(applicationContext, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MyActivity", "SecondActivity onStart")
        Toast.makeText(this, "SecondActivity onStart ", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Log.d("MyActivity", "SecondActivity onResume")
        Toast.makeText(this, "SecondActivity onResume", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Log.d("MyActivity", "SecondActivity onPause")
        Toast.makeText(this, "SecondActivity onPause", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Log.d("MyActivity", "SecondActivity onStop")
        Toast.makeText(this, "SecondActivity onStop", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyActivity", "SecondActivity onDestroy")
        Toast.makeText(this, "SecondActivity onDestroy", Toast.LENGTH_SHORT).show()
    }
}