package com.matdev.claseandroidapi.apod

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matdev.claseandroidapi.ResulNasa
import com.matdev.claseandroidapi.model.entity.Apod
import kotlinx.coroutines.launch

class ApodViewModel(private val apodRepository: ApodRepository = ApodRepository()): ViewModel() {
    val apods = MutableLiveData<ArrayList<Apod>>()
    val error = MutableLiveData<Exception>()

    fun getApods(cant: Int) {
        viewModelScope.launch {
            val res = apodRepository.getApods(cant)
            when(res) {
                is ResulNasa.Success -> apods.value = res.data!!
                is ResulNasa.Error -> error.value = res.error
            }
        }
    }
}