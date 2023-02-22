package com.example.applicationlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LifecycleImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_image)
    }
}