package com.example.webview.recyclerGrid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.webview.R
import com.example.webview.databinding.ItemGalleryLayoutBinding

class GalleryAdapter(val imageList: List<Int>):RecyclerView.Adapter<GalleryAdapter.MyViewHolder>(){
    private var recyclerViewListener:RecyclerViewListener?=null

    inner class MyViewHolder(val binding:ItemGalleryLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(imageId:Int){
            binding.imageView.setImageResource(imageId)
        }
        init {
            binding.root.setOnClickListener {
                recyclerViewListener?.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemGalleryLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun getItemCount(): Int {
        return imageList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(imageList[position])

    }
    fun setListener(listener: RecyclerViewListener){
        recyclerViewListener=listener
    }


}