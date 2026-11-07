package com.example.webview.spiner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.R
import com.example.webview.databinding.SpinerLayoutBinding

class SpinerActivity :AppCompatActivity() {
    lateinit var binding:SpinerLayoutBinding
    private var monthPosition=0
    private var yearPosition=0
    private lateinit var yearList:List<String>
    private lateinit var monthList:Array<String>
    private lateinit var dayList:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SpinerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = resources.getStringArray(R.array.countries)
        dayList = generateDay()
        monthList = resources.getStringArray(R.array.months)
        yearList = generateYears()
        binding.apply {
            spinnerCountries.adapter=ArrayAdapter(this@SpinerActivity,
            android.R.layout.simple_dropdown_item_1line,countries)

            val dayAdapter=ArrayAdapter(this@SpinerActivity,
            android.R.layout.simple_dropdown_item_1line,dayList)

            spinnerDay.adapter=dayAdapter

            spinnerMonth.adapter=ArrayAdapter(this@SpinerActivity,
            android.R.layout.simple_dropdown_item_1line,monthList)

            spinnerYear.adapter=ArrayAdapter(this@SpinerActivity,
            android.R.layout.simple_dropdown_item_1line,yearList)

            spinnerYear.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    yearPosition=position
                    generateDay()
                    spinnerDay.adapter=ArrayAdapter(this@SpinerActivity,
                    android.R.layout.simple_dropdown_item_1line,dayList)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
            spinnerMonth.onItemSelectedListener=object
                :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    monthPosition=position
                    generateDay()
                    spinnerDay.adapter=ArrayAdapter(this@SpinerActivity,
                    android.R.layout.simple_dropdown_item_1line,dayList)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
                }
        }
    }

    private fun generateYears(): List<String> {
        val list=ArrayList<String>()
        list.add("Year")
        for (year in 2023 downTo 1923){
            list.add(year.toString())
        }
        return list

    }

    private fun generateDay(): ArrayList<String> {
        dayList=ArrayList()
      dayList.add("Day")
        if (yearPosition!=0 && monthPosition!=0){
            when(monthPosition){
                1,3,5,7,8,10,12->{
                    dayList.addAll(generateCurrentDay(31))
                }
                4,6,9,11->{
                    dayList.addAll(generateCurrentDay(30))
                }
                2->{
                    val currentYear=yearList[yearPosition].toInt()
                    if (currentYear%100==0){
                        if (currentYear%400==0){
                            dayList.addAll(generateCurrentDay(29))
                        }
                        else{
                            dayList.addAll(generateCurrentDay(28))
                        }
                    }
                    else{
                        if (currentYear%4==0)
                            dayList.addAll(generateCurrentDay(29))
                        else
                            dayList.addAll(generateCurrentDay(28))
                    }
                }
            }
        }
        return dayList

    }

    private fun generateCurrentDay(to: Int): ArrayList<String> {
        val list=ArrayList<String>()
        for (day in 1..to)
            list.add(day.toString())
        return list
    }
}