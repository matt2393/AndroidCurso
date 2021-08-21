package com.matdev.appcurso.main.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matdev.appcurso.ResultFood
import com.matdev.appcurso.model.CategoryModel
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository = CategoryRepository()): ViewModel() {
    val categories = MutableLiveData<CategoryModel>()
    val errorCategory = MutableLiveData<Exception>()
    fun getCategories() {
        viewModelScope.launch {
            val res = categoryRepository.getCategories()
            when(res) {
                is ResultFood.Success -> categories.value = res.data!!
                is ResultFood.Error -> errorCategory.value = res.error
            }
        }
    }
}