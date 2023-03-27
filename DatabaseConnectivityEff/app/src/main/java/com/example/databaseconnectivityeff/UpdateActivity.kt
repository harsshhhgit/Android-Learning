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
import kotlinx.coroutines.launch

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        supportActionBar!!.title = "Update User"

        val updateUsername = findViewById<TextInputEditText>(R.id.updateUsername)
        val updatePassword = findViewById<TextInputEditText>(R.id.updatePassword)
        val updateBtn = findViewById<Button>(R.id.updateBtn)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)

        updateUsername.setText(intent.getStringExtra("username"))
        updatePassword.setText(intent.getStringExtra("pwd"))

        val dbId = intent.getIntExtra("position", 0)+1

        updateBtn.setOnClickListener{
            val database = UserDatabase.getInstance(this)
            val repository = UserRepository(database.getUserDao())
            var userViewModelFactory = UserViewModelFactory(repository)

            var userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)
            lifecycleScope.launch(Dispatchers.IO){
                userViewModel.updateUser(User(id = dbId, username = updateUsername.text.toString(), password = updatePassword.text.toString()))
            }
            Toast.makeText(this@UpdateActivity, "User Updated Successfully", Toast.LENGTH_SHORT).show()
            intent = Intent(this@UpdateActivity, DashboardAllData::class.java)
            startActivity(intent)
        }
        deleteBtn.setOnClickListener{
            val database = UserDatabase.getInstance(this)
            val repository = UserRepository(database.getUserDao())
            var userViewModelFactory = UserViewModelFactory(repository)

            var userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)
            lifecycleScope.launch(Dispatchers.IO){
                userViewModel.deleteUser(User(id = dbId, username = updateUsername.text.toString(), password = updatePassword.text.toString()))
            }
            Toast.makeText(this@UpdateActivity, "User Deleted Successfully", Toast.LENGTH_SHORT).show()
            intent = Intent(this@UpdateActivity, DashboardAllData::class.java)
            startActivity(intent)
        }


    }
}

