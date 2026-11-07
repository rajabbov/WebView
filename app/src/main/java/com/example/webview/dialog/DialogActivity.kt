package com.example.webview.dialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.LayoutBinding

class DialogActivity :AppCompatActivity() {
    lateinit var binding:LayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=LayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name=intent.getStringExtra("name")
        val email=intent.getStringExtra("email")
        binding.textName.text="Name: ${name.toString()}"
        binding.textEmail.text="Email: ${email.toString()}"
    }
}