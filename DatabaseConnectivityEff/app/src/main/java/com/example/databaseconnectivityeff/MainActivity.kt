package com.example.databaseconnectivityeff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.databaseconnectivityeff.entity.User
import com.example.databaseconnectivityeff.viewmodel.UserViewModel
import com.example.databaseconnectivityeff.viewmodel.UserViewModelFactory
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Main Activity"

        val mainRegisterBtn = findViewById<Button>(R.id.mainRegisterBtn)
        val mainLoginBtn = findViewById<Button>(R.id.mainLoginBtn)

        mainRegisterBtn.setOnClickListener{
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        mainLoginBtn.setOnClickListener{
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}