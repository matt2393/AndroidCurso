package com.matdev.claseandroidapi.model.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    val request: RetrofitRequest = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitRequest::class.java)
}