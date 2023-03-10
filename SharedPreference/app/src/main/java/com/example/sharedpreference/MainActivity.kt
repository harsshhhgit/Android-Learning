package com.example.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var userName : TextInputEditText
    lateinit var password : TextInputEditText
    lateinit var dataTransferBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.usernameInputLayout)
        password = findViewById(R.id.passwordInputLayout)
        dataTransferBtn = findViewById(R.id.dataTransferButton)
        dataTransferBtn.setOnClickListener{
            intent = Intent(this, DataTransfer::class.java)
            startActivity(intent)
        }

    }
    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        retrieveData()
    }
    fun saveData(){
        var sp = this.getSharedPreferences("sharedPrefApp", MODE_PRIVATE)
        var editor = sp.edit()
        editor.putString("userName", userName.text.toString())
        editor.putString("password", password.text.toString())
        editor.apply()
        Toast.makeText(this, "Saving Data...", Toast.LENGTH_SHORT).show()
    }
    fun retrieveData(){
        var sp = this.getSharedPreferences("sharedPrefApp", MODE_PRIVATE)
        userName.setText(sp.getString("userName", null))
        password.setText(sp.getString("password", null))
        Toast.makeText(this, "Retrieving Data...", Toast.LENGTH_SHORT).show()
    }
}