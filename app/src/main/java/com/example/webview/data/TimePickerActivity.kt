package com.example.webview.data

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.ActivityTimePickerBinding

class TimePickerActivity :AppCompatActivity() {
    lateinit var binding:ActivityTimePickerBinding
    private var selectedHour=""
    private var selectedMinute=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendar=Calendar.getInstance()
        selectedHour=calendar.get(Calendar.HOUR).toString()
        selectedMinute=calendar.get(Calendar.MINUTE).toString()

        binding.showTimePickerBtn.setOnClickListener {
            val timePickerDialog=TimePickerDialog(this,
            TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                selectedHour=hour.toString()
                selectedMinute=minute.toString()
                if (selectedHour=="0"){
                    if (selectedMinute=="0")
                        binding.selectedTimeTv.text = "0$selectedHour:0$selectedMinute"
                    else
                        binding.selectedTimeTv.text = "0$selectedHour:0$selectedMinute"
                }
                else if (selectedMinute=="0")
                    binding.selectedTimeTv.text="$selectedHour:0$selectedMinute"
                else
                    binding.selectedTimeTv.text="$selectedHour:$selectedMinute"
            },
                selectedHour.toInt(),
                selectedMinute.toInt(),
                true
            )
            timePickerDialog.show()
            timePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).text="Tanla"

        }
    }
    }
