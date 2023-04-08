package com.harsh1x4.bindingdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh1x4.bindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)

        mainActivityBinding.button.setOnClickListener {
            intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra("username", mainActivityBinding.username.text.toString())
            intent.putExtra("password", mainActivityBinding.password.text.toString())
            startActivity(intent)
        }
    }
}