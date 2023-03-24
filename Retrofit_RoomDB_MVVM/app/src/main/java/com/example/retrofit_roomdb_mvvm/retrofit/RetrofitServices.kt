package com.example.retrofit_roomdb_mvvm.retrofit

import com.example.retrofit_roomdb_mvvm.model.Employee
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {
    @GET("users")
    suspend fun getAllUsers() : Response<List<Employee>>
}