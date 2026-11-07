package com.example.webview.dialog

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R



class RadioDialogActivity :AppCompatActivity() {
    private var checkItemPosition=0
    private val list= arrayOf("First","Second","Thirty")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_layout)

        val button:Button=findViewById(R.id.dialogBtn)

        button.setOnClickListener {
            val dialog=AlertDialog.Builder(this)
                .setTitle("Choose one")
                .setCancelable(false)
                .setSingleChoiceItems(list,checkItemPosition){
                        _,position ->
                    checkItemPosition=position
                }
                .setPositiveButton("Ok"){_,_ ->
                    finish()
                }
                .setNegativeButton("Cancel"){_,_ ->}
                .create()
            dialog.show()

        }

    }
}