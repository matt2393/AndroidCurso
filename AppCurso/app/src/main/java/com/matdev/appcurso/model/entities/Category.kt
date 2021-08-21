package com.matdev.appcurso.model.entities


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Category(
    var idCategory: String = "",
    var strCategory: String = "",
    var strCategoryDescription: String = "",
    var strCategoryThumb: String = ""
) : Parcelable