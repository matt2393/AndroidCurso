package com.matdev.appcurso.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.bumptech.glide.Glide
import com.matdev.appcurso.R
import com.matdev.appcurso.cart.CartActivity
import com.matdev.appcurso.databinding.ActivityMainBinding
import com.matdev.appcurso.main.category.CategoryAdapter
import com.matdev.appcurso.main.category.CategoryViewModel
import com.matdev.appcurso.main.meal_star.MealStarAdapter
import com.matdev.appcurso.main.meal_star.MealStarViewModel
import com.matdev.appcurso.meal.MealActivity
import java.util.*
import kotlin.math.abs
import kotlin.math.max


class MainActivity : AppCompatActivity() {
    private val viewModelMeal: MealStarViewModel by viewModels()
    private val viewModelCategories: CategoryViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var adapterMeal: MealStarAdapter? = null
    private var adapterCategory: CategoryAdapter? = null
    private var timer: Timer? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterMeal = MealStarAdapter { url, image ->
            Glide.with(this)
                .load(url)
                .into(image)
        }
        val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset).toFloat()
        binding.viewPagerMain.adapter = adapterMeal
        binding.viewPagerMain.clipToPadding = false
        binding.viewPagerMain.clipChildren = false
        binding.viewPagerMain.offscreenPageLimit = 3
        binding.viewPagerMain.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val com = CompositePageTransformer()
        com.addTransformer(MarginPageTransformer(0))
        com.addTransformer { page, position ->
            /*val r = 1 - abs(position)
            page.scaleY = 0.95f + r * 0.05f*/
            val myOffset = position * -(2 * pageOffset + pageMargin)
            when {
                position < -1 -> {
                    page.translationX = -myOffset
                }
                position <= 1 -> {
                    val scaleFactor = max(0.7f, 1 - abs(position - 0.14285715f))
                    page.translationX = myOffset
                    page.scaleY = scaleFactor
                    page.alpha = scaleFactor
                }
                else -> {
                    page.alpha = 0f
                    page.translationX = myOffset
                }
            }
        }
        binding.viewPagerMain.setPageTransformer(com)

        adapterCategory = CategoryAdapter(loadImage = { url, image ->
            Glide.with(this)
                .load(url)
                .into(image)
        }, click = {
            startActivity(
                Intent(this, MealActivity::class.java)
                    .putExtra(MealActivity.CATEGORY, it)
            )
        })
        binding.recyclerCategoryMain.layoutManager = LinearLayoutManager(this)
        binding.recyclerCategoryMain.adapter = adapterCategory
    }

    override fun onStart() {
        super.onStart()
        initObserves()
        viewModelMeal.getMealStars()
        viewModelCategories.getCategories()
        val timerTask = object: TimerTask() {
            override fun run() {
                runOnUiThread {
                    var i = binding.viewPagerMain.currentItem
                    if(i == binding.viewPagerMain.size-1) {
                        i = 0
                    } else{
                        i++
                    }
                    binding.viewPagerMain.currentItem = i

                }
            }
        }
        timer = Timer()
        timer?.schedule(timerTask, 1000, 1000)
    }

    override fun onStop() {
        super.onStop()
        removeObservers()
        timer?.cancel()
        timer?.purge()
        timer = null
    }

    private fun initObserves() {
        viewModelMeal.mealStars.observe(this, {
            adapterMeal?.arrayMeals = it.meals
            adapterMeal?.notifyItemRangeInserted(0, it.meals.size)
        })
        viewModelMeal.errorMealStars.observe(this, {
            Log.e("ErrorMealStar", it.toString())
            Toast.makeText(this, "Error Meals", Toast.LENGTH_SHORT).show()
        })
        viewModelCategories.categories.observe(this,  {
            adapterCategory?.arrayCategories = it.categories
            adapterCategory?.notifyDataSetChanged()
        })
        viewModelCategories.errorCategory.observe(this, {
            Log.e("ErrorCategories", it.toString())
            Toast.makeText(this, "Error Category", Toast.LENGTH_SHORT).show()
        })
    }
    private fun removeObservers() {
        viewModelMeal.mealStars.removeObservers(this)
        viewModelMeal.errorMealStars.removeObservers(this)
        viewModelCategories.categories.removeObservers(this)
        viewModelCategories.errorCategory.removeObservers(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menuCarrito) {
            startActivity(Intent(this, CartActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}