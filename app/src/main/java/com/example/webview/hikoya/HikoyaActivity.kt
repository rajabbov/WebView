package com.example.webview.hikoya

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.HikoyaLayoutBinding

class HikoyaActivity :AppCompatActivity() {
    private var hikoyalar= arrayListOf("Bo'g'irsoq Ertagi","Til va Yurak","Zumrad va Qimmat","Yaxshilik ketidan yaxshilik keladi",
    "Tulki va Chumoli","Samoviy Poyga")
    lateinit var binding:HikoyaLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HikoyaLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position=intent.getIntExtra("position",0)
        supportActionBar?.title=hikoyalar[position]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Toast.makeText(this,"$position tanlandi",Toast.LENGTH_SHORT).show()

        binding.titleName.text=hikoyalar[position]

        when(position){
            0->binding.textView.text=resources.getString(R.string.BogirsoqErtagi)
            1->binding.textView.text=resources.getString(R.string.TilvaYurak)
            2->binding.textView.text=resources.getString(R.string.Zumradvaqimmat)
            3->binding.textView.text=resources.getString(R.string.Yaxshilikketida)
            4->binding.textView.text=resources.getString(R.string.TulkivaChumoli)
            5->binding.textView.text=resources.getString(R.string.Samoviypoyga)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}