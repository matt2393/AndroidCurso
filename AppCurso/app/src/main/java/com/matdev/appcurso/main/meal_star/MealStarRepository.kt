package com.matdev.appcurso.main.meal_star

import com.matdev.appcurso.ResultFood
import com.matdev.appcurso.model.MealsModel
import com.matdev.appcurso.model.rest.RetrofitSingleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealStarRepository {

    suspend fun getMealStar(): ResultFood<MealsModel> {
        return withContext(Dispatchers.IO) {
            try {
                val res = RetrofitSingleton.request.getMealsStar()
                ResultFood.Success(res)
            } catch (ex: Exception) {
                ResultFood.Error(ex)
            }
        }
    }
}