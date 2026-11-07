package com.example.webview.picture

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.CelebrityimageBinding

class CelebrityImageActivity :AppCompatActivity() {
    private val actiyor= arrayListOf("Ilon Mask","Mark Zuckerberg","Bill Gates","Cristiano Ranaldo"
    ,"Mayk Tyson","Shah Rukh Khan")

    lateinit var binding:CelebrityimageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=CelebrityimageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position",0)
        supportActionBar?.title=actiyor[position]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(position){
            0->binding.celebrityImage.setImageResource(R.drawable.ilonmask)
            1->binding.celebrityImage.setImageResource(R.drawable.markzuckerberg)
            2->binding.celebrityImage.setImageResource(R.drawable.billgates)
            3->binding.celebrityImage.setImageResource(R.drawable.ranaldo)
            4->binding.celebrityImage.setImageResource(R.drawable.mayktayson)
            5->binding.celebrityImage.setImageResource(R.drawable.shoxruxon)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}