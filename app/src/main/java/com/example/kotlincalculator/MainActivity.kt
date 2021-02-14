package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException


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

    fun onOperator(view:View){
        val textViewInput : TextView = findViewById(R.id.textViewInput)
        if(lastNumeric && !isOperatorAdded(textViewInput.text.toString())){
            textViewInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    fun onEqual(view : View){
        val textViewInput : TextView = findViewById(R.id.textViewInput)
        if(lastNumeric){
            var textViewValue = textViewInput.text.toString()
            try {
                var prefix = ""

                // handling the negative numbers
                if(textViewValue.startsWith("-")){
                    prefix="-"
                    textViewValue = textViewValue.substring(1)
                }

                // operation to be performed on subtraction
                if(textViewValue.contains("-")){
                    val splitValue = textViewValue.split("-")
                    var firstNumber = splitValue[0]
                    var secondNumber = splitValue[1]

                    if(!prefix.isEmpty()){
                        firstNumber = prefix + firstNumber
                    }

                    textViewInput.text = (firstNumber.toDouble() - secondNumber.toDouble()).toString()
                }
                // operation to be performed on addition
                if(textViewValue.contains("+")){
                    val splitValue = textViewValue.split("+")
                    var firstNumber = splitValue[0]
                    var secondNumber = splitValue[1]

                    if(!prefix.isEmpty()){
                        firstNumber = prefix + firstNumber
                    }

                    textViewInput.text = (firstNumber.toDouble() + secondNumber.toDouble()).toString()
                }
                //operation to be performed on multiply
                if(textViewValue.contains("*")){
                    val splitValue = textViewValue.split("*")
                    var firstNumber = splitValue[0]
                    var secondNumber = splitValue[1]

                    if(!prefix.isEmpty()){
                        firstNumber = prefix + firstNumber
                    }

                    textViewInput.text = (firstNumber.toDouble() * secondNumber.toDouble()).toString()
                }
                //operation to be performed on divide
                if(textViewValue.contains("/")){
                    val splitValue = textViewValue.split("/")
                    var firstNumber = splitValue[0]
                    var secondNumber = splitValue[1]

                    if(!prefix.isEmpty()){
                        firstNumber = prefix + firstNumber
                    }

                    textViewInput.text = (firstNumber.toDouble() / secondNumber.toDouble()).toString()
                }
            }catch (e:ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    // function to check is operator added
    private fun isOperatorAdded(value : String) : Boolean{
        return if(value.startsWith("-")){
            return false
        }else{
            value.contains("/") || value.contains("+") || value.contains("-") || value.contains("*")
        }
    }
}