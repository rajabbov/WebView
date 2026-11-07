package com.example.webview

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.databinding.ActivityLayoutBinding
import com.example.webview.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity1 :AppCompatActivity() {
    private lateinit var binding:ActivityLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.generateBtn.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
            val from=binding.slider.values[0]
            val to = binding.slider.values[1]

            if (binding.checkbox.isChecked){
                val randomNumber = Random.nextInt(from.toInt(), to.toInt())
                binding.resultTv.text= "Generate number: $randomNumber"
            }else{
                val randomNumber = Random.nextDouble(from.toDouble(), to.toDouble())
                binding.resultTv.text = String.format("Generate number: %.3f",randomNumber)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_layout,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                onBackPressed()
            }
            R.id.setting_id->{
                Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show()
            }
            R.id.white_id->{
                binding.root.setBackgroundColor(Color.WHITE)
            }
            R.id.black_id->{
                binding.root.setBackgroundColor(Color.BLACK)
            }
            R.id.blue_id->{
                binding.root.setBackgroundColor(Color.BLUE)
            }
            R.id.Red_id->{
                binding.root.setBackgroundColor(Color.RED)
            }
            R.id.yellow_id->{
                binding.root.setBackgroundColor(Color.YELLOW)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}