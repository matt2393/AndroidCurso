package com.matdev.claseandroidapi.apod

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matdev.claseandroidapi.R
import com.matdev.claseandroidapi.databinding.ItemMainBinding
import com.matdev.claseandroidapi.model.entity.Apod

class MainAdapter(var arrayApods: ArrayList<Apod> = arrayListOf(),
                  val loadImage: (url: String, image:ImageView) -> Unit): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemMainBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_main, parent, false)
        )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val apod = arrayApods[position]
        holder.binding.textMain.text = apod.title
        loadImage(apod.url, holder.binding.imageMain)
    }

    override fun getItemCount(): Int = arrayApods.size
}