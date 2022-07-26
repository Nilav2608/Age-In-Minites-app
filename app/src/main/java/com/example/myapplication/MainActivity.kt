package com.example.myapplication

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDatePicker.setOnClickListener {view->
            clickDatePicker(view)

        }


    }

    fun clickDatePicker(view: View) {

       val myCalender = Calendar.getInstance()
       val year = myCalender.get(Calendar.YEAR)
       val month = myCalender.get(Calendar.MONTH)
       val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view,SelectedYear,SelectedMonth,SelectedDayOfMonth ->
                Toast.makeText(this,"You chosen Year is  $SelectedYear,the month is $SelectedMonth,the day is $SelectedDayOfMonth",Toast.LENGTH_LONG).show()

                val SelectedDate = "$SelectedDayOfMonth/${SelectedMonth+1}/$SelectedYear"
                tvSelectedDate.setText(SelectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val theDate = sdf.parse(SelectedDate)

                val formattedDate = sdf.parse(SelectedDate)
                val timeInSeconds = (myCalender.timeInMillis-formattedDate.time)/1000
                val resutTextView = findViewById<TextView>(R.id.SelectedDateInMinutes)
                resutTextView.setText(timeInSeconds.toString())



            }
            , year,month,day).show()

    }




}