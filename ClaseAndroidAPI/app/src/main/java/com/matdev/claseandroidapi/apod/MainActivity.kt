package com.matdev.claseandroidapi.apod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.matdev.claseandroidapi.R
import com.matdev.claseandroidapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: ApodViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var adapter: MainAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MainAdapter { url, image ->
            Glide.with(this)
                .load(url)
                .into(image)
        }

        binding.recyclerMain.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerMain.adapter = adapter
        viewModel.getApods(10)

    }

    override fun onStart() {
        super.onStart()
        initObserves()
    }

    override fun onStop() {
        super.onStop()
        removeObserves()
    }
    private fun initObserves() {
        viewModel.apods.observe(this, {
            adapter?.arrayApods?.addAll(it)
            adapter?.notifyItemRangeInserted(0, it.size)
        })
        viewModel.error.observe(this, {
            Log.e("APOSERROR", it.toString())
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        })
    }
    private fun removeObserves() {
        viewModel.apods.removeObservers(this)
        viewModel.error.removeObservers(this)
    }
}