package com.matdev.appcurso

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.matdev.appcurso.model.entities.Meal
import java.lang.reflect.Type


const val PREF_NOM = "APPCURSO"
const val CART = "CART"
fun saveCart(context: Context, arrayMeals: ArrayList<Meal>) {
    val pref = context.getSharedPreferences(PREF_NOM, MODE_PRIVATE)
    val aux = Gson().toJson(arrayMeals)
    pref.edit()
        .putString(CART, aux)
        .apply()
}

fun getCart(context: Context): ArrayList<Meal>? {
    val pref = context.getSharedPreferences(PREF_NOM, MODE_PRIVATE)
    val aux = pref.getString(CART, "")
    return if(aux.isNullOrEmpty()) {
        null
    } else {
        val type: Type = object:  TypeToken<ArrayList<Meal>>(){}.type
        Gson().fromJson(aux, type)
    }
}