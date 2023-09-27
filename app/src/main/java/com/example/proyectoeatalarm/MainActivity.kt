package com.example.proyectoeatalarm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun abrirCrearAlarma(view: View){
        val intent = Intent(this,CrearAlarma::class.java).apply {
            startActivity(intent)
        }
    }
}
