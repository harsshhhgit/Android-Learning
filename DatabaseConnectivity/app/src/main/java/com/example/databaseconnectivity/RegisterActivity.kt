package com.example.databaseconnectivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.databaseconnectivity.entity.User
import com.example.databaseconnectivity.repository.UserRepository
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    lateinit var userNameLayout : TextInputEditText
    lateinit var passwordLayout : TextInputEditText
    lateinit var signInBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.title = "Register"

        userNameLayout = findViewById(R.id.usernameInputLayout)
        passwordLayout = findViewById(R.id.passwordInputLayout)
        signInBtn = findViewById(R.id.signIn)

        signInBtn.setOnClickListener{
            UserRepository(applicationContext).insertUser(
                User(0, username = userNameLayout.text.toString(),
                password= passwordLayout.text.toString())
            )
            Toast.makeText(applicationContext, "User Registered Successfully", Toast.LENGTH_SHORT).show()
            intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}