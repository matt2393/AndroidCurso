package com.matdev.appcurso.meal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matdev.appcurso.ResultFood
import com.matdev.appcurso.model.MealsModel
import kotlinx.coroutines.launch

class MealViewModel(private val mealRepository: MealRepository = MealRepository()): ViewModel() {
    val meals = MutableLiveData<MealsModel>()
    val errrorMeals = MutableLiveData<Exception>()

    fun getMeals(category: String) {
        viewModelScope.launch {
            val res = mealRepository.getMeals(category)
            when(res) {
                is ResultFood.Success -> meals.value = res.data!!
                is ResultFood.Error -> errrorMeals.value = res.error
            }
        }
    }
}