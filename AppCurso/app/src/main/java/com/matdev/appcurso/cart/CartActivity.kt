package com.matdev.appcurso.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.matdev.appcurso.databinding.ActivityCartBinding
import com.matdev.appcurso.getCart
import com.matdev.appcurso.saveCart

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datos = getCart(this)

        if(datos!=null) {
            val adapter = CartAdapter(arrayMeals = datos,
                loadImage = { url, image ->
                    Glide.with(this)
                        .load(url)
                        .into(image)
                }, remove = {
                    saveCart(this, it)
                })
            binding.recyclerCart.layoutManager = LinearLayoutManager(this)
            binding.recyclerCart.adapter = adapter
        }

    }
}