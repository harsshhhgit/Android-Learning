package com.example.retrofit_roomdb_mvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_roomdb_mvvm.repository.EmployeeRepository

class EmployeeViewModelFactory(val employeeRepository: EmployeeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeViewModel(employeeRepository) as T
    }

}