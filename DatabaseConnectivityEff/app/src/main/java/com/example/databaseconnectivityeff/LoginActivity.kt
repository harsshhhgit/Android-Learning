package com.example.databaseconnectivityeff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.databaseconnectivityeff.database.UserDatabase
import com.example.databaseconnectivityeff.entity.User
import com.example.databaseconnectivityeff.repository.UserRepository
import com.example.databaseconnectivityeff.viewmodel.UserViewModel
import com.example.databaseconnectivityeff.viewmodel.UserViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    lateinit var loginUsername: TextInputEditText
    lateinit var loginPassword: TextInputEditText
    lateinit var signInBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.title = "Login Here"

        loginUsername = findViewById(R.id.loginUsername)
        loginPassword = findViewById(R.id.loginPassword)
        signInBtn = findViewById(R.id.signIn)

        signInBtn.setOnClickListener{
            val database = UserDatabase.getInstance(this)
            val repository = UserRepository(database.getUserDao())
            var userViewModelFactory = UserViewModelFactory(repository)
            var userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)

            lifecycleScope.async(Dispatchers.IO) {
                var userDataEntered: User = userViewModel.getUser(
                    loginUsername.text.toString(),
                    loginPassword.text.toString()
                )
                withContext(Dispatchers.Main){
                    if(userDataEntered == null){
                        Toast.makeText(applicationContext, "User Invalid", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext, "User Signed In Successfully", Toast.LENGTH_SHORT).show()
                        intent = Intent(this@LoginActivity, DashboardAllData::class.java)
                        startActivity(intent)
                    }
                }
            }

        }
    }
}