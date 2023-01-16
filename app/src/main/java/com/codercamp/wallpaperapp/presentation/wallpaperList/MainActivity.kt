package com.codercamp.wallpaperapp.presentation.wallpaperList

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.codercamp.wallpaperapp.R
import com.codercamp.wallpaperapp.databinding.ActivityMainBinding
import com.codercamp.wallpaperapp.domain.model.ImageLists
import com.codercamp.wallpaperapp.presentation.wallpaperList.adapter.CustomAdapter
import com.codercamp.wallpaperapp.presentation.wallpaperList.adapter.OnItemClick
import com.codercamp.wallpaperapp.presentation.wallpaperView.WallpaperViewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnItemClick{
    private val viewModel: ImageListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.getImages("1")


        viewModel.isLoading.observe(this){

        }
        viewModel.successMessage.observe(this){
            viewModel.imageList.value?.let { it1 ->
                binding.recyclerView.hasFixedSize()
                binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,
                    LinearLayoutManager.VERTICAL)
                val adapter = CustomAdapter(it1,this)
                binding.recyclerView.adapter = adapter
            }

        }
    }

    override fun onItemSelected(position: Int, item: ImageLists) {
        val intent = Intent(this, WallpaperViewActivity::class.java)
        intent.putExtra("image_Url", item.urls!!.regular)
        startActivity(intent)
    }
}