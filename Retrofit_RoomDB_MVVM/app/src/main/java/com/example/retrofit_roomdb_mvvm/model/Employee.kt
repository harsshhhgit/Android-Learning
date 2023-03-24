package com.example.retrofit_roomdb_mvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var empId: Int,
    var _id: Int,
    var firstName: String,
    var lastName: String,
    var emailId: String,
    var imageUrl: String,
    var designation: String,
    var department: String,
    var status: String,
    var position: String,
    var bloodGroup: String,
    var phoneNumber: String
)