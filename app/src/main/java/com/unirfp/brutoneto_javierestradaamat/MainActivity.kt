package com.unirfp.brutoneto_javierestradaamat

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnCalc).setOnClickListener{

            val brutoAnual = findViewById<EditText>(R.id.brutoAnual)
            val nPagas = findViewById<EditText>(R.id.nPagas)
            val nEdad = findViewById<EditText>(R.id.nEdad)
            val gDiscapacidad = findViewById<EditText>(R.id.gDiscapacidad)
            val gProfesional = findViewById<EditText>(R.id.gProfesional)
            val nHijos = findViewById<EditText>(R.id.nHijos)
            val eCivil = findViewById<EditText>(R.id.eCivil)
            val error = findViewById<TextView>(R.id.error)

            if (brutoAnual.text.isNotEmpty() && nPagas.text.isNotEmpty()) {
                // Navegar a la siguiente ventana
                val intent = Intent(this, salarioneto::class.java)
                // Añadimos los valores que queremos pasar a la otra ventana

                intent.putExtra("brutoAnual", brutoAnual.text.toString().toInt())



                intent.putExtra("nPagas", nPagas.text.toString().toDouble())
                intent.putExtra("nEdad", nEdad.text.toString().toInt())
                intent.putExtra("gDiscapacidad", gDiscapacidad.text.toString())
                intent.putExtra("gProfesional",gProfesional.text.toString())
                intent.putExtra("nHijos",nHijos.text.toString().toInt())
                intent.putExtra("eCivil", eCivil.text.toString())


                // Iniciamos la otra ventana
                startActivity(intent)

            } else {
                error.setText("Debes de rellenar todos los campos")
                error.setTextColor(Color.RED)
            }


        }


    }
}