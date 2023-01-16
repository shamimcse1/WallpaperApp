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

class CustomAdapter(private val mList: List<ImageLists>,private val mListener: OnItemClick ) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.image_item, parent, false)
		return ViewHolder(view,mListener)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val items = mList[position]
		holder.bind(items)
	}

	override fun getItemCount(): Int {
		return mList.size
	}
	class ViewHolder(ItemView: View,private val onItemClick: OnItemClick) : RecyclerView.ViewHolder(ItemView) {
		private val imageView: ImageView = itemView.findViewById(R.id.item_photo_iv)

		fun  bind(item: ImageLists) = with(itemView){
			Glide.with(context).load(item.urls!!.small_s3).into(imageView)
			itemView.setOnClickListener{
				onItemClick.onItemSelected(adapterPosition,item)
			}
		}

	}
}
