package com.example.databaseconnectivityeff

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
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var userNameLayout: TextInputEditText
    lateinit var passwordLayout: TextInputEditText
    lateinit var regBtn: Button
    lateinit var factory: UserViewModelFactory
    lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.title = "Register Here"

        userNameLayout = findViewById(R.id.regUsername)
        passwordLayout = findViewById(R.id.regPassword)
        regBtn = findViewById(R.id.registerBtn)

        regBtn.setOnClickListener {
            val database = UserDatabase.getInstance(this)
            val repository = UserRepository(database.getUserDao())
            var userViewModelFactory = UserViewModelFactory(repository)

            var userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)
            lifecycleScope.launch(Dispatchers.IO){
                userViewModel.insertUser(User(id=0, userNameLayout.text.toString(), passwordLayout.text.toString()))
            }
            Toast.makeText(applicationContext, "User Registered Successfully", Toast.LENGTH_SHORT)
                .show()
        }
    }
}