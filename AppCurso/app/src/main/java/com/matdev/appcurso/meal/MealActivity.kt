package com.matdev.appcurso.meal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.matdev.appcurso.ConfirmAddDialog
import com.matdev.appcurso.R
import com.matdev.appcurso.databinding.ActivityMealBinding
import com.matdev.appcurso.getCart
import com.matdev.appcurso.model.entities.Category
import com.matdev.appcurso.saveCart

class MealActivity : AppCompatActivity() {
    companion object {
        const val CATEGORY = "CATEGORY"
    }
    private val viewModel: MealViewModel by viewModels()
    var category: Category? = null
    private lateinit var binding: ActivityMealBinding
    private var adapter: MealAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent?.let {
            category = it.getParcelableExtra(CATEGORY)
        }

        if(category!=null) {
            binding.collapsingMeal.title = category?.strCategory
            Glide.with(this)
                .load(category?.strCategoryThumb)
                .into(binding.imageCategoryMeal)

            adapter = MealAdapter(loadImage = { url, image ->
                Glide.with(this)
                    .load(url)
                    .into(image)
            }, click = {
                ConfirmAddDialog.newInstance(it)
                    .show(supportFragmentManager, "Confirm")
            })
            binding.recyclerMeals.layoutManager = GridLayoutManager(this, 2)
            binding.recyclerMeals.adapter = adapter

        } else {
            Toast.makeText(this, "Error en la categoria", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        initObserves()
        viewModel.getMeals(category!!.strCategory)
    }

    override fun onStop() {
        super.onStop()
        removeObservers()
    }

    private fun initObserves() {
        viewModel.meals.observe(this, {
            adapter?.arrayMeals = it.meals
            adapter?.notifyItemRangeInserted(0, it.meals.size)
        })
        viewModel.errrorMeals.observe(this, {
            Log.e("ErrorMeals", it.toString())
            Toast.makeText(this, "Error Meals", Toast.LENGTH_SHORT).show()
        })

    }
    private fun removeObservers() {
        viewModel.meals.removeObservers(this)
        viewModel.errrorMeals.removeObservers(this)
    }
}