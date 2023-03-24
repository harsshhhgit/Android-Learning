package com.example.retrofit_roomdb_mvvm.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val URL = "https://dummyjson.com/products?limit=5"

    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}