package com.example.retrofit_roomdb_mvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofit_roomdb_mvvm.dao.EmployeeDao
import com.example.retrofit_roomdb_mvvm.model.Employee

@Database(entities = [Employee::class], version=1)
abstract class EmployeeDatabase : RoomDatabase(){
    abstract fun getUserDao() : EmployeeDao

    companion object{
        private var instance : EmployeeDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : EmployeeDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context.applicationContext,
                    EmployeeDatabase::class.java, "employee_database").build()
            }
            return instance!!
        }
    }
}