package com.example.databaseconnectivityeff.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.databaseconnectivityeff.entity.User
import com.example.databaseconnectivityeff.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserViewModel(private val userRepository: UserRepository) : ViewModel(){

    suspend fun insertUser(user: User){
        userRepository.insertUser(user)
    }
    fun getUser(username: String, password: String) : User {
        return userRepository.getUser(username, password)
    }
//    fun getAllUser() : LiveData<List<User>>{
//        return userRepository.getAllUser().asLiveData()
//    }
    var users : LiveData<List<User>> = userRepository.getAllUser().asLiveData()

    fun updateUser(user: User){
        userRepository.updateUser(user)
    }
    fun deleteUser(user: User){
        userRepository.deleteUser(user)
    }
}
