package com.example.proyectoeatalarm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.Toast



class ListaAlarmas : AppCompatActivity() {

    private lateinit var eliminar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listaalarma)

        val simpleDialogo = AlertDialog.Builder(this)
            .setTitle("")
            .setMessage("Esta seguro que desea Eliminar la Alarma")
            .setPositiveButton("Aceptar"){ _, _ ->
                Toast.makeText(this,"Alarma Eliminada",Toast.LENGTH_SHORT).show()

            }
            .setNegativeButton("Cancelar"){ _, _ ->
                Toast.makeText(this,"",Toast.LENGTH_SHORT).show()

            }
            .create()

             eliminar =findViewById(R.id.eliminar)

             eliminar.setOnClickListener{
                 simpleDialogo.show()
             }



    }

    fun abrirCrearAlarma(view: View){
        val intent = Intent(this,CrearAlarma::class.java).apply { }
        startActivity(intent)
    }

    fun abrirEditarAlarma(view: View){
        val intent = Intent(this,ModificarAlarma::class.java).apply { }
        startActivity(intent)
    }

    fun abrirRecomendaciones(view: View){
        val intent = Intent(this,Recomendaciones::class.java).apply { }
        startActivity(intent)
    }

    fun abrirConfiguracion(view: View){
        val intent = Intent(this,Configuracion::class.java).apply { }
        startActivity(intent)
    }

    fun abrirReporte(view: View){
        val intent = Intent(this,Reporte::class.java).apply { }
        startActivity(intent)
    }

}


