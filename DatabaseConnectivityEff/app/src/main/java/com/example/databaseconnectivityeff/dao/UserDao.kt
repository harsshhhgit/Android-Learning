package com.example.databaseconnectivityeff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.databaseconnectivityeff.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("select * from user where username = :username and password = :password")
    fun getUser(username: String, password: String) : User

    @Query("select * from user ORDER BY id ASC")
    fun getAllUser(): Flow<List<User>>

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}