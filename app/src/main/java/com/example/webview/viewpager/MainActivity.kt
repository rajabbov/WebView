package com.example.webview.viewpager

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.ViewPagerLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity :AppCompatActivity() {
    lateinit var binding: ViewPagerLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ViewPagerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customViewPagerAdapter = CustomViewPagerAdapter(this)
        binding.myViewPager.adapter = customViewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.myViewPager) { tab, position ->
            tab.text = "Title $position"
        }.attach()
    }

}


