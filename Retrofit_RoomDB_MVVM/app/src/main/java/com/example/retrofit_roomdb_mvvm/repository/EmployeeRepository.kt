package com.example.retrofit_roomdb_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit_roomdb_mvvm.database.EmployeeDatabase
import com.example.retrofit_roomdb_mvvm.model.Employee
import com.example.retrofit_roomdb_mvvm.retrofit.RetrofitServices

class EmployeeRepository(val retrofitServices: RetrofitServices, private val employeeDatabase: EmployeeDatabase) {
    var userData = MutableLiveData<List<Employee>>()
    var userLiveData : LiveData<List<Employee>> = userData
    suspend fun getAllUsers(){
        val result = retrofitServices.getAllUsers()
        if(result?.body() != null){
            result.body()!!.map { emp ->
                employeeDatabase.getUserDao().insertEmployee(emp)
            }
            userData.postValue(result.body())
        }
    }
}