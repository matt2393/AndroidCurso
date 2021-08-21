package com.matdev.appcurso.main.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.matdev.appcurso.R
import com.matdev.appcurso.databinding.ItemCategoryBinding
import com.matdev.appcurso.model.entities.Category

class CategoryAdapter(var arrayCategories: ArrayList<Category> = arrayListOf(),
                      val loadImage:(url: String, image:ImageView) -> Unit,
                      val click:(cat: Category) -> Unit): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemCategoryBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val cat = arrayCategories[position]
        holder.binding.textItemCategory.text = cat.strCategory
        loadImage(cat.strCategoryThumb, holder.binding.imageItemCategory)
        holder.binding.root.setOnClickListener {
            click(cat)
        }
    }

    override fun getItemCount(): Int = arrayCategories.size
}