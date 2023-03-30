package com.example.databaseconnectivity.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.databaseconnectivity.entity.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("select * from user where username = :username and password = :password")
    fun getUser(username: String, password: String) : User

    @Query("select * from user ORDER BY id ASC")
    fun getAllUser(): List<User>
}