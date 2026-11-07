package com.example.webview.delete

import RecyclerViewListener
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.webview.databinding.ContactListItemBinding


class MyCustomAdapter(val list:MutableList<String>) :RecyclerView.Adapter<com.example.webview.delete.MyCustomAdapter.MyViewHolder>() {
    private var recyclerViewListener: RecyclerViewListener? = null

    inner class MyViewHolder(val binding: ContactListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String) {
            binding.titlrTv.text = title
        }

        init {
            binding.deleteBtn.setOnClickListener {
                recyclerViewListener?.onDeleteBtnClick(adapterPosition)


            }
        }
    }

    fun setListener(listener: RecyclerViewListener) {
        recyclerViewListener = listener
    }

    private class MyDiffUtil(val oldList:List<String>,val newList:List<String>):DiffUtil.Callback(){
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition]===newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition]==newList[newItemPosition]
        }

    }

     fun submitList(newList:List<String>){
         val resultDiffUtil = DiffUtil.calculateDiff(MyDiffUtil(list,newList))
         list.clear()
         list.addAll(newList)
         resultDiffUtil.dispatchUpdatesTo(this)
     }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val title = list[position]
        holder.bind(title)

    }



    }

