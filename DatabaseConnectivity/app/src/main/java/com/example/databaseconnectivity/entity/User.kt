package com.example.databaseconnectivity.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var username: String,
    var password: String)