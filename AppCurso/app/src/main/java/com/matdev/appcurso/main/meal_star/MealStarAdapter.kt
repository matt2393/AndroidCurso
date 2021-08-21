package com.matdev.appcurso.main.meal_star

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.matdev.appcurso.R
import com.matdev.appcurso.databinding.ItemMealViewpagerBinding
import com.matdev.appcurso.model.entities.Meal

class MealStarAdapter(var arrayMeals: ArrayList<Meal> = arrayListOf(),
                      val loadImage: (url: String, image: ImageView) -> Unit): RecyclerView.Adapter<MealStarAdapter.MealStarViewHolder>() {
    inner class MealStarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemMealViewpagerBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MealStarViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_meal_viewpager, parent, false)
        )

    override fun onBindViewHolder(holder: MealStarViewHolder, position: Int) {
        val meal = arrayMeals[position]
        loadImage(meal.strMealThumb, holder.binding.imageMealViewPager)
    }

    override fun getItemCount(): Int = arrayMeals.size
}