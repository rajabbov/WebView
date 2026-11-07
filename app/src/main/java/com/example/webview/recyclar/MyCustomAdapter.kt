package com.example.webview.recyclar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.webview.databinding.ItemRecylerLayoutBinding

class MyCustomAdapter(val list:List<Model>):
RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>(){

    inner class MyViewHolder(val binding:ItemRecylerLayoutBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(title: Model, phone:Model){
            binding.titleView.text=title.name
            binding.phone.text=phone.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=ItemRecylerLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val title=list[position]
        val phone=list[position]
        holder.bind(title,phone)
    }

    }
