package com.matdev.appcurso.meal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.matdev.appcurso.R
import com.matdev.appcurso.databinding.ItemMealsBinding
import com.matdev.appcurso.model.entities.Meal

class MealAdapter(var arrayMeals: ArrayList<Meal> = arrayListOf(),
                  val loadImage:(url: String, image: ImageView) -> Unit,
                  val click:(meal: Meal) -> Unit): RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    inner class MealViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemMealsBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MealViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_meals, parent, false)
        )

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = arrayMeals[position]
        holder.binding.textItemMeal.text = meal.strMeal
        loadImage(meal.strMealThumb, holder.binding.imageItemMeal)
        holder.binding.root.setOnLongClickListener {
            click(meal)
            true
        }
    }

    override fun getItemCount(): Int = arrayMeals.size
}