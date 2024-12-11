package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao: String
        val cor: Int

        if (result <= 18.5f) {
            classificacao = "MAGREZA"
            cor = Color.BLUE // Azul para magreza
        } else if (result <= 24.9f) {
            classificacao = "NORMAL"
            cor = Color.GREEN // Verde para normal
        } else if (result <= 29.9f) {
            classificacao = "SOBREPESO"
            cor = Color.rgb(255, 165, 0) // Laranja
        } else if (result <= 39.9f) {
            classificacao = "OBESIDADE"
            cor = Color.RED // Magenta para obesidade
        } else {
            classificacao = "OBESIDADE GRAVE"
            cor = Color.MAGENTA // Vermelho para obesidade grave
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(cor)
    }
}