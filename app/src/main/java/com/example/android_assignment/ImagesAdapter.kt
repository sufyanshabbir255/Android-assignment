package com.example.android_assignment

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImagesAdapter(private val mListImages: ArrayList<String>, private val context: Context) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mListImages[position]
        Glide.with(context)
            .load(itemsViewModel)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return mListImages.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<String>) {
        this.mListImages.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image: ImageView = itemView.findViewById(R.id.ivImage)
    }
}