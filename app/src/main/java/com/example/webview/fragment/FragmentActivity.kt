package com.example.webview.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.FragmentLayoutBinding

class FragmentActivity :AppCompatActivity() {
    lateinit var binding:FragmentLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment=FirstFragment().apply {
            arguments=Bundle().apply {
                putString("key1","Nima gap")
            }
        }
        val secondFragment=SecondFragment().apply {
            arguments=Bundle().apply {
                putString("key2","Yaxshi")
            }
        }

        binding.showFirstFragmentBtn.setOnClickListener {
            supportFragmentManager.apply {
                beginTransaction().replace(R.id.containerView,firstFragment).commit()
            }
        }
        binding.showSecondFragmentBtn.setOnClickListener {
            supportFragmentManager.apply {
                beginTransaction().replace(R.id.containerView,secondFragment).commit()
            }
        }
    }
}