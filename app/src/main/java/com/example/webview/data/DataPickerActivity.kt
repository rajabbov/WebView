package com.example.webview.data

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.DataLayoutBinding

class DataPickerActivity :AppCompatActivity() {
    lateinit var binding:DataLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showDatePickerBtn.setOnClickListener {
            val calendar=Calendar.getInstance()
            val dataPickerDialog=DatePickerDialog(
                this,0,
                DatePickerDialog.OnDateSetListener {
                        _,year,month, day ->
                    binding.selecteDateTv.text="$day/${month+1}/$year"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_YEAR)
            )
            calendar.set(Calendar.DAY_OF_MONTH,31)
            dataPickerDialog.datePicker.maxDate= calendar.timeInMillis
            calendar.set(Calendar.DAY_OF_MONTH,17)
            dataPickerDialog.datePicker.minDate=calendar.timeInMillis

            dataPickerDialog.show()
            dataPickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).text="Tanla"

        }
    }
}