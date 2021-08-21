package com.matdev.appcurso.meal

import com.matdev.appcurso.ResultFood
import com.matdev.appcurso.model.MealsModel
import com.matdev.appcurso.model.rest.RetrofitSingleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MealRepository {
    suspend fun getMeals(category: String): ResultFood<MealsModel> {
        return withContext(Dispatchers.IO) {
            try {
                val res = RetrofitSingleton.request.getMealCategory(category)
                ResultFood.Success(res)
            } catch (ex: Exception) {
                ResultFood.Error(ex)
            }
        }
    }
}