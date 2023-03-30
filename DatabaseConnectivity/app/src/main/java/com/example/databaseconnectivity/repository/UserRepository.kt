package com.example.databaseconnectivity.repository

import android.content.Context
import androidx.annotation.WorkerThread
import com.example.databaseconnectivity.dao.UserDao
import com.example.databaseconnectivity.database.UserDatabase
import com.example.databaseconnectivity.entity.User

class UserRepository(context: Context) {

    private lateinit var userDao : UserDao
    private var database = UserDatabase.getInstance(context)

    init{
        userDao = database.getUserDao()
    }

    fun insertUser(user: User){
        userDao.insertUser(user)
    }
    fun getUser(username: String, password: String) : User{
        return userDao.getUser(username, password)
    }
    fun getAllUser() : List<User>{
        return userDao.getAllUser()
    }
}