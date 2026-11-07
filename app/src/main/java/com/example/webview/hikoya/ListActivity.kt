package com.example.webview.hikoya

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.ListItemHikoyaBinding

class ListActivity :AppCompatActivity() {
    lateinit var binding:ListItemHikoyaBinding
    private var hikoyalar= arrayListOf("Bo'g'rsoq Ertagi","Til va Yurak","Zumrad va Qimmat","Yaxshilik ketidan yaxshilik keladi",
    "Tulki va Chumoli","Samoviy Poyga")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ListItemHikoyaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter=ArrayAdapter<String>(
            this,android.R.layout.simple_list_item_1,hikoyalar
        )
        binding.listViewHikoya.adapter=adapter

        binding.listViewHikoya.setOnItemClickListener { _,_,position,_ ->
            Toast.makeText(this,"$position tanlandi",Toast.LENGTH_SHORT).show()
            Intent(this,HikoyaActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }
    }
}