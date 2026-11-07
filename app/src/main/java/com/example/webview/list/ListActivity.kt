package com.example.webview.list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.ListactivityBinding

class ListActivity :AppCompatActivity() {
    lateinit var binding:ListactivityBinding
    private val fruits= arrayListOf<FruitModel>(
        FruitModel("Olma", R.drawable.olma),
        FruitModel("Banan", R.drawable.banan),
        FruitModel("O'rik", R.drawable.apricot),
        FruitModel("Uzum", R.drawable.uzum),
        FruitModel("Nok", R.drawable.nok),

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ListactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter=CustomAdapter(this,fruits)
        binding.listView.adapter=adapter

        binding.listView.setOnItemClickListener { _,_,position,_ ->
            Toast.makeText(this, "${fruits[position]} tanlandi", Toast.LENGTH_SHORT).show()

            Intent(this, FruitImageActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }


    }
}