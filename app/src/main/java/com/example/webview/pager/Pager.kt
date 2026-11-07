package com.example.webview.pager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.IntroPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class Pager :AppCompatActivity() {
    lateinit var binding:IntroPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= IntroPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list= listOf<ModelData>(
            ModelData(R.drawable.telegram,"Telegram","Telegram desktop"),
            ModelData(R.drawable.telegram,"Fast","Fast desktop"),
            ModelData(R.drawable.telegram,"Gift","Gift.com"),
            ModelData(R.drawable.telegram,"Cloud","Cloud.com"),
            ModelData(R.drawable.telegram,"Powerful","Powerful desktop"),
        )
        val customPagerAdapter=CustomPagerAdapter(this,list)
        binding.viewPager.adapter=customPagerAdapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position ->

        }.attach()
    }
}