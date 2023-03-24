package com.example.retrofit_roomdb_mvvm.dao

import androidx.room.*
import com.example.retrofit_roomdb_mvvm.model.Employee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
    @Insert
    fun insertEmployee(user: Employee)

    @Query("select * from employee ORDER BY _id ASC")
    fun getAllEmployee(): Flow<List<Employee>>

    @Update
    fun updateEmployee(user: Employee)

    @Delete
    fun deleteEmployee(user: Employee)
}
