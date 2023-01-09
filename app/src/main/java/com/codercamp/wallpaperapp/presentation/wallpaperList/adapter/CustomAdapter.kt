package com.codercamp.wallpaperapp.presentation.wallpaperList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codercamp.wallpaperapp.R
import com.codercamp.wallpaperapp.domain.model.ImageLists

class CustomAdapter(private val mList: List<ImageLists>,private val context : Context ) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.image_item, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val items = mList[position]
		Glide.with(context).load(items.urls).into(holder.imageView);
	}

	override fun getItemCount(): Int {
		return mList.size
	}
	class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
		val imageView: ImageView = itemView.findViewById(R.id.image)
	}
}
