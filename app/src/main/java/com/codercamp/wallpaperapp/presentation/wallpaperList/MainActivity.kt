package com.codercamp.wallpaperapp.presentation.wallpaperList

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.codercamp.wallpaperapp.R
import com.codercamp.wallpaperapp.common.Status
import com.codercamp.wallpaperapp.databinding.ActivityMainBinding
import com.codercamp.wallpaperapp.domain.model.ImageLists
import com.codercamp.wallpaperapp.presentation.wallpaperList.adapter.CustomAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ImageListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initErrorMessage()
        initRecyclerView()
        viewModel.getImages("1")
    }

    private fun initRecyclerView() {
        binding.recyclerView.hasFixedSize()
        binding.recyclerView.layoutManager = GridLayoutManager(this,3)
        val adapter = viewModel.status.value.images?.let { CustomAdapter(it, this) }
        binding.recyclerView.adapter = adapter
    }

    private fun initErrorMessage() {
        Toast.makeText(this, viewModel.status.value.error.toString(), Toast.LENGTH_LONG).show()
    }
}