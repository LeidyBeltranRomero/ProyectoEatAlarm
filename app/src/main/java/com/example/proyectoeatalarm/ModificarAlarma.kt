package com.example.proyectoeatalarm

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ModificarAlarma : AppCompatActivity() {

    private lateinit var btnDatePicker: Button
    private lateinit var tvSelectedDate: TextView

    private lateinit var spinner: Spinner
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private val calendar = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_alarma)
        val languages1 = resources.getStringArray(R.array.Languages1)
        val horas1 = resources.getStringArray(R.array.horas1)

        btnDatePicker = findViewById(R.id.flechafecha)
        tvSelectedDate = findViewById(R.id.fechaLabel)

        spinner = findViewById(R.id.spinner)
        spinner1 = findViewById(R.id.spinnerVecesAlDia)
        spinner2 = findViewById(R.id.spinnerhoraPrimeraComida)
        // Set a click listener on the "Select Date" button
        btnDatePicker.setOnClickListener {
            // Show the DatePicker dialog
            showDatePicker()
        }

        val adapter = ArrayAdapter.createFromResource(this,
            R.array.Languages1, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter
        spinner1.adapter = adapter

        val adapter1 = ArrayAdapter.createFromResource(this,
            R.array.horas1, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter= adapter1
    }
    private fun showDatePicker() {
        // Create a DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            this, R.style.DatePickerTheme,{DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Create a new Calendar instance to hold the selected date
                val selectedDate = Calendar.getInstance()
                // Set the selected date using the values received from the DatePicker dialog
                selectedDate.set(year, monthOfYear, dayOfMonth)
                // Create a SimpleDateFormat to format the date as "dd/MM/yyyy"
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                // Format the selected date into a string
                val formattedDate = dateFormat.format(selectedDate.time)
                // Update the TextView to display the selected date with the "Selected Date: " prefix
                tvSelectedDate.text = "$formattedDate"
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        // Show the DatePicker dialog
        datePickerDialog.show()
    }

    fun getValues(view: View) {
        Toast.makeText(this, "Spinner 1 " + spinner.selectedItem.toString()
            , Toast.LENGTH_LONG).show()
    }

    fun abrirListaAlarmas(view: View){
        val intent = Intent(this,ListaAlarmas::class.java).apply { }
        startActivity(intent)
    }

    fun abrirCrearAlarma(view: View){
        val intent = Intent(this,MainActivity::class.java).apply { }
        startActivity(intent)
    }


}

