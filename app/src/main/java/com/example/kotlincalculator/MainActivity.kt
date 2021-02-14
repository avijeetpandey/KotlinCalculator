package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
        val textViewInput : TextView = findViewById(R.id.textViewInput)
        textViewInput.append((view as Button).text)
    }

    fun onClear(view : View){
        val textViewInput : TextView = findViewById(R.id.textViewInput)
        textViewInput.text=""
    }
}