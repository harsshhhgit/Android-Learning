package com.example.retrofit_roomdb_mvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_roomdb_mvvm.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(val employeeRepository: EmployeeRepository): ViewModel(){
    init {
        viewModelScope.launch(Dispatchers.IO){
            employeeRepository.getAllUsers()
        }
    }
    val userLiveData = employeeRepository.userLiveData
}