package com.example.webview

import android.os.Bundle
import android.view.View.OnCreateContextMenuListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.databinding.ListactivityBinding

class ListViewActivity :AppCompatActivity() {
    lateinit var binding:ListactivityBinding
    private val fruits= arrayListOf("Olam","Banan","Gilos","Nok","Apelsin","Uzum","Shaftoli")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ListactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, fruits)
        binding.listView.adapter=adapter

        binding.listView.setOnItemClickListener { _, _, potision, _ ->
            Toast.makeText(this, "${fruits[potision]}",Toast.LENGTH_SHORT).show()

        }
    }
}