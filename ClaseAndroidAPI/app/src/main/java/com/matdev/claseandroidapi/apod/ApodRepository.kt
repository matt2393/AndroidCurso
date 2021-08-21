package com.matdev.claseandroidapi.apod

import com.matdev.claseandroidapi.ResulNasa
import com.matdev.claseandroidapi.model.entity.Apod
import com.matdev.claseandroidapi.model.rest.RetrofitSingleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApodRepository {
    suspend fun getApods(cant: Int): ResulNasa<ArrayList<Apod>> {
        return withContext(Dispatchers.IO) {
            try {
                val res = RetrofitSingleton.request.getApods(cant)
                ResulNasa.Success(res)
            } catch(ex: Exception) {
                ResulNasa.Error(ex)
            }
        }
    }
}