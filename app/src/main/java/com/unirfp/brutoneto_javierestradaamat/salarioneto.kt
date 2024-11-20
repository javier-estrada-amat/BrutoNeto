package com.unirfp.brutoneto_javierestradaamat

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class salarioneto : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_salarioneto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val df = DecimalFormat("#.##")

        //Recogemos el texviw donde vamos a escribir

        val resultTV = findViewById<TextView>(R.id.txtCalculado)

        //Recogemos los datos que pusimos en el putExtra

        val brutoAnual = intent.extras?.getInt("brutoAnual") ?: 0

        //Log.i("Debug", "Valor recibido de brutoAnual: $brutoAnual")

        val nPagas = intent.extras?.getDouble("nPagas") ?: 0
        val nEdad = intent.extras?.getInt("nEdad") ?: 0
        val gDiscapacidad = intent.extras?.getString("gDiscapacidad")
        val gProfesional = intent.extras?.getString("gProfesional")
        val nHijos = intent.extras?.getInt("nHijos") ?: 0
        val eCivil = intent.extras?.getString("eCivil")
        val porcentaje = 0.10
        val calculo = df.format(brutoAnual * porcentaje).toDouble()
        val neto = df.format(brutoAnual - calculo).toDouble()

        resultTV.text = "Se ha calculado correctamente su salario anual neto \n " +
                "Neto: $neto € \n" +
                "Se le ha reducido un 10% \n" +
                "Por lo cual el total reducido es de $calculo€"






    }
}