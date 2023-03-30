package com.example.databaseconnectivity.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databaseconnectivity.dao.UserDao
import com.example.databaseconnectivity.entity.User

@Database(entities = [User::class], version=1)
abstract class UserDatabase : RoomDatabase(){
    abstract fun getUserDao() : UserDao

    companion object{
        private var instance : UserDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : UserDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context.applicationContext,
                    UserDatabase::class.java, "user_mgmt").allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}