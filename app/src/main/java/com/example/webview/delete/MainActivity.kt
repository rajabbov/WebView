package com.example.webview.delete

import RecyclerViewListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webview.databinding.ContactLayoutBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Collections

class MainActivity :AppCompatActivity() {
    lateinit var binding: ContactLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf<String>()
        val customAdapter = MyCustomAdapter(list)
        val myLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.recyclerView.apply {
            adapter = customAdapter
            layoutManager = myLayoutManager

            addItemDecoration(DividerItemDecoration(this@MainActivity, myLayoutManager.orientation))

                }
        val itemTouchHelper=ItemTouchHelper(object  :MyTouchHelper(){
            override fun onItemSwipelToDelete(position: Int) {
                val removedTitle=list.removeAt(position)
                customAdapter.notifyItemRemoved(position)
                Snackbar.make(this@MainActivity,binding.recyclerView,"$removedTitle ochirilyapti",
                Snackbar.LENGTH_SHORT)
                    .setAction("Tiklash"){
                        list.add(position,removedTitle)
                        customAdapter.notifyItemInserted(position)
                    }.show()
            }

            override fun onItemMoved(from: Int, to: Int) {
                Collections.swap(list,from,to)
                customAdapter.notifyItemMoved(from,to)

            }
        })
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

        customAdapter.setListener(object  :RecyclerViewListener{
            override fun onDeleteBtnClick(position: Int) {
                list.removeAt(position)
                customAdapter.notifyItemRemoved(position)
            }

            })
            binding.addBtn.setOnClickListener {
                val title = binding.titlrEt.text.toString()
                val newList = mutableListOf<String>()
                newList.addAll(list)
                if (title.isNotBlank()) {
                    newList.add(title.trim())
                    customAdapter.submitList(newList)
                    binding.titlrEt.text.clear()

                }


            }


        }
    }
