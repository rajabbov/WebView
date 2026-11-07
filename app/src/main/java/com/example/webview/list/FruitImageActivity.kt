package com.example.webview.list

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.FruitimageBinding

class FruitImageActivity: AppCompatActivity() {
    private val fruits= arrayListOf("olma","Banan","O'rik","Uzum","Nok")

    lateinit var binding:FruitimageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FruitimageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position=intent.getIntExtra("position",0)
        supportActionBar?.title=fruits[position]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(position){
            0->binding.fruitImage.setImageResource(R.drawable.olma)
            1->binding.fruitImage.setImageResource(R.drawable.banan)
            2->binding.fruitImage.setImageResource(R.drawable.apricot)
            3->binding.fruitImage.setImageResource(R.drawable.uzum)
            4->binding.fruitImage.setImageResource(R.drawable.nok)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}