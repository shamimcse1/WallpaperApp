package com.codercamp.wallpaperapp.presentation.wallpaperView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.codercamp.wallpaperapp.R
import com.codercamp.wallpaperapp.databinding.ActivityMainBinding
import com.codercamp.wallpaperapp.databinding.ActivityWallpaperViewBinding

class WallpaperViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWallpaperViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wallpaper_view);
        val imageUrl :String = intent.getStringExtra("image_Url").toString()
        Glide.with(this).load(imageUrl).into(binding.fullImageView)

    }
}