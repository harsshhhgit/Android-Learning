package com.example.databaseconnectivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.databaseconnectivity.entity.User
import com.example.databaseconnectivity.repository.UserRepository
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerButton = findViewById<Button>(R.id.register)
        val loginButton = findViewById<Button>(R.id.logIn)

        registerButton.setOnClickListener{
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener{
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
//        val taskList = arrayListOf<String>()
//        taskList.add("Take out the trash")
//        taskList.add("Do this dishes")
//        taskList.add("Vacuum the living room")
//        taskList.add("Mop the kitchen floor")
//        taskList.add("Wash the laundry")
//        taskList.add("Buy groceries")
//        taskList.add("Pay bills")
//        taskList.add("Go for a run")
//        taskList.add("Attend a meeting")
//        taskList.add("Finish project report")

    }
}