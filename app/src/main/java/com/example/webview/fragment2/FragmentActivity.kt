package com.example.webview.fragment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.Fragment2LayoutBinding

class FragmentActivity :AppCompatActivity(), FirstFragmentInterface {
    lateinit var binding:Fragment2LayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= Fragment2LayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstFragment=BlankFragment()
        val secondFragment=BlankFragment2()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container2,firstFragment).commit()

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.apply {
                beginTransaction().replace(R.id.container2,firstFragment).addToBackStack(null).commit()

            }
        }
        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.apply {
                beginTransaction().replace(R.id.container2,secondFragment).addToBackStack(null).commit()

            }
        }
    }

    override fun onClickButton(text: String) {
        val secondFragment=BlankFragment2().apply {
            arguments=Bundle().apply {
                putString("key",text)
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container2,secondFragment)
            .addToBackStack(null)
            .commit()

    }
}