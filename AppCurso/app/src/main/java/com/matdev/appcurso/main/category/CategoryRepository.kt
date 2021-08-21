package com.matdev.appcurso.main.category

import com.matdev.appcurso.ResultFood
import com.matdev.appcurso.model.CategoryModel
import com.matdev.appcurso.model.rest.RetrofitSingleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository {
    suspend fun getCategories(): ResultFood<CategoryModel> {
        return withContext(Dispatchers.IO) {
            try {
                val res = RetrofitSingleton.request.getCategories()
                ResultFood.Success(res)
            } catch (ex: Exception) {
                ResultFood.Error(ex)
            }
        }
    }
}