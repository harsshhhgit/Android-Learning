package com.example.databaseconnectivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.databaseconnectivity.entity.User
import com.example.databaseconnectivity.repository.UserRepository
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<TextInputEditText>(R.id.loginUsername)
        val password = findViewById<TextInputEditText>(R.id.loginPassword)
        val signInButton = findViewById<Button>(R.id.signIn)

        signInButton.setOnClickListener{
            var user : User = UserRepository(applicationContext).getUser(username.text.toString(), password.text.toString())
            if(user == null){
                Toast.makeText(applicationContext, "User Invalid", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "User Signed In Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}