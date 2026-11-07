package com.example.webview.dialog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.CustomDialogBinding
import com.example.webview.databinding.DialogLayoutBinding

class MyCustomDialog :AppCompatActivity() {
    lateinit var binding:DialogLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DialogLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialogBtn.setOnClickListener {
            val dialogViewBinding = CustomDialogBinding.inflate(layoutInflater,null,false)
            val dialog = AlertDialog.Builder(this)
                .setView(dialogViewBinding.root)
                .setPositiveButton("Sign In"){_,_ ->
                    Intent(this,DialogActivity::class.java).apply {
                        val name=dialogViewBinding.name.text.toString()
                        val email=dialogViewBinding.email.text.toString()
                        intent.putExtra("name1",name)
                        intent.putExtra("email1",email)
                        startActivity(this)
                    }
                }
                .setNegativeButton("Cancel"){_,_ ->}
            dialogViewBinding.OKBtn.setOnClickListener {
                val intent=Intent(this,DialogActivity::class.java).also {
                    it.putExtra("name","${dialogViewBinding.name.text}")
                    it.putExtra("email","${dialogViewBinding.email.text}")
                    startActivity(it)
                }
            }
            dialog.show()
        }
    }
}