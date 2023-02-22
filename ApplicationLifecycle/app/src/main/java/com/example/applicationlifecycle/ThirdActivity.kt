package com.example.applicationlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        Log.d("MyActivity", "ThirdActivity onCreate")
        Toast.makeText(this, "ThirdActivity onCreate ", Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        Log.d("MyActivity", "ThirdActivity onStart")
        Toast.makeText(this, "ThirdActivity onStart ", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Log.d("MyActivity", "ThirdActivity onResume")
        Toast.makeText(this, "ThirdActivity onResume", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Log.d("MyActivity", "ThirdActivity onPause")
        Toast.makeText(this, "ThirdActivity onPause", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Log.d("MyActivity", "ThirdActivity onStop")
        Toast.makeText(this, "ThirdActivity onStop", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyActivity", "ThirdActivity onDestroy")
        Toast.makeText(this, "ThirdActivity onDestroy", Toast.LENGTH_SHORT).show()
    }
}