package com.example.webview.recyclerGrid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.webview.R
import com.example.webview.databinding.ActivityGalleryBinding

class GalleryActivity :AppCompatActivity() {
    lateinit var binding:ActivityGalleryBinding
    val list= listOf<Int>(
        R.drawable.spark,
        R.drawable.nexia,
        R.drawable.kaptiva,
        R.drawable.bmw1,
        R.drawable.bmw2,
        R.drawable.bmw3,
        R.drawable.toyota1,
        R.drawable.toyota2,
        R.drawable.toyota3,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val galleryAdapter=GalleryAdapter(list)
        val manager=GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false)
        val myManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        binding.recyclerView.apply {
            adapter=galleryAdapter
            layoutManager=myManager
        }

        galleryAdapter.setListener(object :RecyclerViewListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@GalleryActivity,"error", Toast.LENGTH_SHORT).show()
                Intent(this@GalleryActivity,ImageViewActivity::class.java).apply {
                    putExtra("image",list[position])
                    startActivity(this)
                }
            }
        })

    }
}