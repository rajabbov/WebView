package com.example.webview.galerey

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.GalleryImageBinding

class GalleryImageActivity :AppCompatActivity() {

    private val gallery= arrayListOf("Olma","Banan","Uzum","Nok","Spark","Nexia","Kaptiva","BMW1","BMW2",
    "BMW3","Toyota1","Toyota2","Toyota3")

    lateinit var binding:GalleryImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= GalleryImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position=intent.getIntExtra("position",0)
        supportActionBar?.title=gallery[position]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        when(position){
            0->binding.galleryImage.setImageResource(R.drawable.olma)
            1->binding.galleryImage.setImageResource(R.drawable.banan)
            2->binding.galleryImage.setImageResource(R.drawable.uzum)
            3->binding.galleryImage.setImageResource(R.drawable.spark)
            4->binding.galleryImage.setImageResource(R.drawable.nexia)
            5->binding.galleryImage.setImageResource(R.drawable.kaptiva)
            6->binding.galleryImage.setImageResource(R.drawable.bmw1)
            7->binding.galleryImage.setImageResource(R.drawable.bmw2)
            8->binding.galleryImage.setImageResource(R.drawable.bmw3)
            9->binding.galleryImage.setImageResource(R.drawable.toyota1)
            10->binding.galleryImage.setImageResource(R.drawable.toyota2)
            11->binding.galleryImage.setImageResource(R.drawable.toyota3)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}