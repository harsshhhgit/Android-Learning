package com.example.databaseconnectivityeff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseconnectivityeff.database.UserDatabase
import com.example.databaseconnectivityeff.repository.UserRepository
import com.example.databaseconnectivityeff.viewmodel.UserAdapter
import com.example.databaseconnectivityeff.viewmodel.UserViewModel
import com.example.databaseconnectivityeff.viewmodel.UserViewModelFactory

class DashboardAllData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_all_data)

        supportActionBar!!.title = "Dashboard"

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var userAdapter = UserAdapter()
        recyclerView.adapter = userAdapter

        val database = UserDatabase.getInstance(this)
        val repository = UserRepository(database.getUserDao())
        var userViewModelFactory = UserViewModelFactory(repository)
        var userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)

        userViewModel.users.observe(this, Observer {users ->
            Log.d("users_count", "$users")
            userAdapter.setDBUsers(users)
        })

    }
}