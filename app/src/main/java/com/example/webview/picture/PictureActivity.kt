//package com.example.webview.picture
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.webview.R
//import com.example.webview.databinding.PictureactivityBinding
//
//class PictureActivity :AppCompatActivity() {
//    lateinit var binding:PictureactivityBinding
//    private val actiyor= arrayListOf<CelebrityModel>(
//        CelebrityModel("Ilon Mask",R.drawable.ilonmask),
//        CelebrityModel("Bill Gates",R.drawable.billgates),
//        CelebrityModel("Mark Zuckerberg ",R.drawable.markzuckerberg),
//        CelebrityModel("Mayk Tyson",R.drawable.mayktayson),
//        CelebrityModel("Cristiano",R.drawable.ranaldo),
//        CelebrityModel("Shah Rukh Khan",R.drawable.shoxruxon),
//
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding= PictureactivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val adapter = CelebrityAdapter(this,actiyor)
//        binding.listview.adapter=adapter
//
//        binding.listview.setOnItemClickListener { _,_,position,_ ->  }
//        Toast.makeText(this,"${actiyor[position]} tanlandi",Toast.LENGTH_SHORT).show()
//        Intent(this,CelebrityImageActivity::class.java).apply {
//            this.putExtra("position",position)
//            startActivity(this)
//        }
//    }
//}