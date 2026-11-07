package com.example.webview.dialog

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R

class AlertDialogActivity :AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_layout)

        val list= arrayOf<String>("First","Second","Thirty")

        val button:Button=findViewById(R.id.dialogBtn)
        button.setOnClickListener {
            val dialog=AlertDialog.Builder(this)
                .setTitle("Choose one")
                .setItems(list,object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@AlertDialogActivity,
                        list[which],Toast.LENGTH_SHORT).show()

                    }
                })
                .setPositiveButton("Ok"
                ){_,position ->
                    finish()
                }
                .create()
            dialog.show()
        }
    }
}



