package com.example.webview.recyclerGrid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.ActivityImageViewBinding

class ImageViewActivity :AppCompatActivity() {
    lateinit var binding:ActivityImageViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityImageViewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val imageId=intent.getIntExtra("image",R.drawable.bmw2)
        binding.imageView.setImageResource(imageId)










    }
}