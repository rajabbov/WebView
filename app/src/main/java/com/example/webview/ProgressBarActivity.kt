package com.example.webview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.databinding.ProgressActivityBinding

class ProgressBarActivity :AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ProgressActivityBinding

    val gmArray= arrayOf(R.drawable.kaptiva,R.drawable.nexia,R.drawable.spark)
    val bmwArray= arrayOf(R.drawable.bmw1,R.drawable.bmw2,R.drawable.bmw3)
    val toyotaArray= arrayOf(R.drawable.toyota1,R.drawable.toyota2,R.drawable.toyota3)
    var imgPosition=0
    var usd1=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ProgressActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextBtn.setOnClickListener(this)
        binding.beforeBtn.setOnClickListener(this)
        binding.gm.setOnClickListener(this)
        binding.bmw.setOnClickListener(this)
        binding.toyota.setOnClickListener(this)
    }

    private fun checkVisibility() {

    }
    override fun onClick(v: View?) {
when(v){
    binding.gm->{
        usd1=1
        imgPosition=0
        binding.progressBarId.visibility=View.VISIBLE
         checkVisibility()
        Thread{
            Thread.sleep(1000)
            runOnUiThread {
                binding.textView.text="Gm"
                binding.imgView.setImageResource(R.drawable.kaptiva)
                binding.progressBarId.visibility= View.INVISIBLE
            }
        }.start()

    }
    binding.bmw->{
        usd1=2
        imgPosition=0
        binding.progressBarId.visibility= View.VISIBLE
        checkVisibility()
        Thread{
            Thread.sleep(1000)
            runOnUiThread {
                binding.textView.text="BMW"
                binding.imgView.setImageResource(R.drawable.bmw1)
                binding.progressBarId.visibility= View.INVISIBLE

    }
}.start()
    }
    binding.toyota-> {
        usd1 = 3
        imgPosition = 0
        binding.progressBarId.visibility = View.VISIBLE
        checkVisibility()
        Thread {
            Thread.sleep(1000)
            runOnUiThread {
                binding.textView.text = "TOYOTA"
                binding.imgView.setImageResource(R.drawable.toyota1)
                binding.progressBarId.visibility = View.INVISIBLE
            }
        }.start()
    }
    binding.nextBtn->{
        if (imgPosition!=2)imgPosition++
        selectImage()
    Toast.makeText(this,"Next bosildi",Toast.LENGTH_SHORT).show()
    }
    binding.beforeBtn->{
        if (imgPosition!=0)imgPosition--
        selectImage()
        Toast.makeText(this,"Befor bosildi",Toast.LENGTH_SHORT).show()
    }
    }
}

    private fun selectImage(){
        chackVisibility()
        when(usd1){
            1->binding.imgView.setImageResource(gmArray[imgPosition])
            2->binding.imgView.setImageResource(bmwArray[imgPosition])
            3->binding.imgView.setImageResource(toyotaArray[imgPosition])
        }
    }

    private fun chackVisibility() {
        when(imgPosition){
            0->{
                binding.nextBtn.visibility=View.VISIBLE
                binding.beforeBtn.visibility=View.INVISIBLE
            }
            1->{
                binding.nextBtn.visibility=View.VISIBLE
                binding.beforeBtn.visibility=View.VISIBLE
            }
            2->{
                binding.nextBtn.visibility=View.INVISIBLE
                binding.beforeBtn.visibility=View.VISIBLE
            }
        }
    }
}

