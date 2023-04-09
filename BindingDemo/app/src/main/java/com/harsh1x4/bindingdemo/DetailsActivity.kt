package com.harsh1x4.bindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call.Details
import android.util.Log
import com.harsh1x4.bindingdemo.databinding.ActivityDetailsBinding
import com.harsh1x4.bindingdemo.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var detailsActivityBinding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsActivityBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailsActivityBinding.root)

        detailsActivityBinding.detailsUsername.text = intent.getStringExtra("username")
        detailsActivityBinding.detailsPassword.text = intent.getStringExtra("password")
    }
}