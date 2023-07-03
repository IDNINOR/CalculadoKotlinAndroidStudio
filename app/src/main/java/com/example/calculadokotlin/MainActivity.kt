package com.example.calculadokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta, 3->multiplicacion, 4->division
    var operacion : Int = 0
    var numero1 : Double = 0.0
    lateinit var txt_numero1 : TextView
    lateinit var txt_numero2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_numero1 = findViewById(R.id.text_res1)
        txt_numero2 = findViewById(R.id.text_res2)

        val btnBorrar : Button = findViewById(R.id.btn_c)
        val btnIgual: Button = findViewById(R.id.btn_igual)

        btnIgual.setOnClickListener {
            var numero2 : Double = txt_numero2.text.toString().toDouble()
            var respuesta : Double = 0.0

            when(operacion){
                1 -> respuesta = numero1 + numero2
                2 -> respuesta = numero1 - numero2
                3 -> respuesta = numero1 * numero2
                4 -> respuesta = numero1 / numero2
            }
            txt_numero2.setText(respuesta.toString())
            txt_numero1.setText("")
        }
        btnBorrar.setOnClickListener {
            txt_numero1.setText("")
            txt_numero2.setText("")
            numero1 = 0.0
            operacion = 0
        }
    }

    fun presionarDigito(View: View){
       // val txt_numero2 : TextView = findViewById(R.id.text_res2)
        var num1 : String = txt_numero2.text.toString()

        when(View.id){
            R.id.btn_0 -> txt_numero2.setText(num1 + "0")
            R.id.btn_1 -> txt_numero2.setText(num1 + "1")
            R.id.btn_2 -> txt_numero2.setText(num1 + "2")
            R.id.btn_3 -> txt_numero2.setText(num1 + "3")
            R.id.btn_4 -> txt_numero2.setText(num1 + "4")
            R.id.btn_5 -> txt_numero2.setText(num1 + "5")
            R.id.btn_6 -> txt_numero2.setText(num1 + "6")
            R.id.btn_7 -> txt_numero2.setText(num1 + "7")
            R.id.btn_8 -> txt_numero2.setText(num1 + "8")
            R.id.btn_9 -> txt_numero2.setText(num1 + "9")
            R.id.btn_punto -> txt_numero2.setText(num1 + ".")
        }
    }

    fun clic_Operacion(View : View){
        numero1 = txt_numero2.text.toString().toDouble()
        var num2 : String = txt_numero2.text.toString()
        txt_numero2.setText("")
        when(View.id){
            R.id.btn_suma -> {
                txt_numero1.setText(num2 + "+")
                operacion = 1
            }
            R.id.btn_resta -> {
                txt_numero1.setText(num2 + "-")
                operacion = 2
            }
            R.id.btn_multiplicar -> {
                txt_numero1.setText(num2 + "*")
                operacion = 3
            }
            R.id.btn_dividir -> {
                txt_numero1.setText(num2 + "/")
                operacion = 4
            }
        }
    }
}