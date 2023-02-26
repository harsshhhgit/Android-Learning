package com.example.applicationlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class LifecycleImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyActivity", "ImageActivity onCreate")
        setContentView(R.layout.activity_lifecycle_image)
    }
    override fun onStart() {
        super.onStart()
        Log.d("MyActivity", "ImageActivity onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MyActivity", "ImageActivity onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MyActivity", "ImageActivity onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MyActivity", "ImageActivity onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyActivity", "ImageActivity onDestroy")
    }
}