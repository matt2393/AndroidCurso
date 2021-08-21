package com.matdev.appcurso.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.matdev.appcurso.R
import com.matdev.appcurso.databinding.ItemCartBinding
import com.matdev.appcurso.model.entities.Meal

class CartAdapter(var arrayMeals: ArrayList<Meal> = arrayListOf(),
                  val loadImage: (url: String, image: ImageView) -> Unit,
                  val remove:(array: ArrayList<Meal>) -> Unit): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    inner class CartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemCartBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CartViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cart, parent, false)
        )

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val meal = arrayMeals[position]
        holder.binding.textItemCart.text = meal.strMeal
        loadImage(meal.strMealThumb, holder.binding.imageItemCart)
        holder.binding.imageRemoveItemCart.setOnClickListener {
            arrayMeals.removeAt(position)
            notifyItemRemoved(position)
            remove(arrayMeals)
        }
    }

    override fun getItemCount(): Int = arrayMeals.size
}