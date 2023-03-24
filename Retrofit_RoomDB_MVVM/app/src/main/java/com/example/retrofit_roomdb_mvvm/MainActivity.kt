package com.example.retrofit_roomdb_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.retrofit_roomdb_mvvm.database.EmployeeDatabase
import com.example.retrofit_roomdb_mvvm.repository.EmployeeRepository
import com.example.retrofit_roomdb_mvvm.retrofit.RetrofitBuilder
import com.example.retrofit_roomdb_mvvm.retrofit.RetrofitServices
import com.example.retrofit_roomdb_mvvm.viewModel.EmployeeViewModel
import com.example.retrofit_roomdb_mvvm.viewModel.EmployeeViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var employeeViewModel: EmployeeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitServices = RetrofitBuilder.getInstance().create(RetrofitServices::class.java)
        val database = EmployeeDatabase.getInstance(this@MainActivity)
        var repository = EmployeeRepository(retrofitServices, database)
        employeeViewModel = ViewModelProvider(this@MainActivity, EmployeeViewModelFactory(repository)).get(EmployeeViewModel::class.java)

        employeeViewModel.userLiveData.observe(this@MainActivity, Observer {
            Log.d("userData", "${it}")
        })

    }
}