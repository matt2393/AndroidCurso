package com.matdev.appcurso.main.meal_star

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matdev.appcurso.ResultFood
import com.matdev.appcurso.model.MealsModel
import kotlinx.coroutines.launch

class MealStarViewModel(private val mealStarRepository: MealStarRepository = MealStarRepository()): ViewModel() {
    val mealStars = MutableLiveData<MealsModel>()
    val errorMealStars = MutableLiveData<Exception>()

    fun getMealStars() {
        viewModelScope.launch {
            val res = mealStarRepository.getMealStar()
            when(res) {
                is ResultFood.Success -> mealStars.value = res.data!!
                is ResultFood.Error -> errorMealStars.value = res.error
            }
        }
    }
}