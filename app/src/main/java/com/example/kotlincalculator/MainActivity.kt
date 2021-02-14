package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var lastNumeric : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
        val textViewInput : TextView = findViewById(R.id.textViewInput)
        textViewInput.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view : View){
        val textViewInput : TextView = findViewById(R.id.textViewInput)
        textViewInput.text=""
        lastDot = false
        lastNumeric = false
    }

    fun onDecimal(view : View){
        val textViewInput : TextView = findViewById(R.id.textViewInput)
        if(lastNumeric && !lastDot){
            textViewInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }
}