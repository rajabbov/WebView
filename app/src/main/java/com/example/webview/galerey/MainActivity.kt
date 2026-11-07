package com.example.webview.galerey

import android.content.Intent
import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.GridviewLayoutBinding

class MainActivity :AppCompatActivity() {
    lateinit var binding:GridviewLayoutBinding
    private val imageList= arrayListOf<Int>(
        R.drawable.bmw1,
        R.drawable.bmw2,
        R.drawable.bmw3,
        R.drawable.toyota1,
        R.drawable.toyota2,
        R.drawable.toyota3,
        R.drawable.kaptiva,
        R.drawable.nexia,
        R.drawable.spark,
        R.drawable.olma,
        R.drawable.banan,
        R.drawable.uzum,
        R.drawable.apricot,
        R.drawable.nok
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=GridviewLayoutBinding.inflate(layoutInflater)
      setContentView(binding.root)

        val adapter=GalleryAdapter(this, imageList )
        binding.gridView.adapter=adapter

        binding.gridView.setOnItemClickListener{_,_,position,_->
            Toast.makeText(this,"${imageList[position]} tanlandi",Toast.LENGTH_SHORT).show()

            Intent(this,GalleryImageActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }
    }
}