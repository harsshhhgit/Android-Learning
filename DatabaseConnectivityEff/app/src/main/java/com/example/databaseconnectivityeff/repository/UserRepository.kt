package com.example.databaseconnectivityeff.repository

import android.content.Context
import androidx.annotation.WorkerThread
import com.example.databaseconnectivityeff.dao.UserDao
import com.example.databaseconnectivityeff.database.UserDatabase
import com.example.databaseconnectivityeff.entity.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }
    fun getUser(username: String, password: String) : User{
        return userDao.getUser(username, password)
    }
    fun getAllUser() : Flow<List<User>>{
        return userDao.getAllUser()
    }
    fun updateUser(user: User){
        userDao.updateUser(user)
    }
    fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
}