package com.example.webview.recyclar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webview.R
import com.example.webview.databinding.RecyclerViewLayoutBinding

class MainActivity :AppCompatActivity() {
    lateinit var binding:RecyclerViewLayoutBinding
    private val name= arrayListOf<Model>(
        Model("Abdulaziz","+998902158530"),
        Model("Abdulaziz","+998902158530"),
        Model("Abdulaziz","+998902158530"),
        Model("Abdulaziz","+998902158530"),
        Model("Abdulaziz","+998902158530"),
        Model("Abdulaziz","+998902158530"),
        Model("Abdulaziz","+998902158530"),

    )
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=RecyclerViewLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customAdapter=MyCustomAdapter(name)
        val myLayoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

            binding.recyclerView.apply {
                adapter=customAdapter
                layoutManager=myLayoutManager
                addItemDecoration(DividerItemDecoration
                    (this@MainActivity,myLayoutManager.orientation))
            }
    }
}