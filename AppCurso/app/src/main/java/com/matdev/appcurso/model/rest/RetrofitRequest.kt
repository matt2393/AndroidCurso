package com.matdev.appcurso.model.rest

import com.matdev.appcurso.model.CategoryModel
import com.matdev.appcurso.model.MealsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitRequest {
    @GET("search.php")
    suspend fun getMealsStar(@Query("f") f: String = "a"): MealsModel
    @GET("categories.php")
    suspend fun getCategories(): CategoryModel
    @GET("filter.php")
    suspend fun getMealCategory(@Query("c") category: String): MealsModel
}