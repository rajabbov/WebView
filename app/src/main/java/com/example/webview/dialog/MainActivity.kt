package com.example.webview.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.DialogLayoutBinding
class MainActivity:AppCompatActivity() {
    lateinit var binding:DialogLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DialogLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialogBtn.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
                .setTitle("Are you sure")
                .setIcon(R.drawable.ic_error)
                .setMessage("Bu malumotlar qayta tiklanmaydi")
                .setPositiveButton("Ok",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog:DialogInterface?,which:Int){
                        Toast.makeText(this@MainActivity,"Ok Button clicked",Toast.LENGTH_SHORT).show()
                        finish()
                    }
                })
                .setNegativeButton("Cancel",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which:Int) {
                        Toast.makeText(this@MainActivity,"Cancel Button clicked", Toast.LENGTH_SHORT).show()


                    }

                })
                .create()
            dialog.show()

        }
    }
}
