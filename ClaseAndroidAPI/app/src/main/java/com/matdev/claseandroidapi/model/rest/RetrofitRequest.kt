package com.matdev.claseandroidapi.model.rest

import com.matdev.claseandroidapi.model.entity.Apod
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitRequest {
    @GET("planetary/apod")
    suspend fun getApods(@Query("count") count: Int,
                         @Query("api_key") apiKey: String = "DEMO_KEY") : ArrayList<Apod>
}