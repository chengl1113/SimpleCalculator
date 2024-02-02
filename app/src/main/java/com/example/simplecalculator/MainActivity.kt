package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton: Button = findViewById(R.id.calculate_button)
        val radioGroup: RadioGroup = findViewById(R.id.radio_group)
        val output: TextView = findViewById(R.id.result_view)


        calculateButton.setOnClickListener {_: View ->
            val firstNum: Double = findViewById<EditText>(R.id.operand_one).text.toString().toDouble()
            val secondNum: Double = findViewById<EditText>(R.id.operand_two).text.toString().toDouble()
            val radioButtonId: Int = radioGroup.checkedRadioButtonId
            val result: String = when (findViewById<RadioButton>(radioButtonId).text.toString()) {
                "+" -> (firstNum + secondNum).toString()
                "-" -> (firstNum - secondNum).toString()
                "x" -> (firstNum * secondNum).toString()
                "/" -> if (secondNum == 0.0) {
                    "Error: cannot divide by 0"
                } else (firstNum / secondNum).toString()

                "%" -> if (secondNum == 0.0) {
                    "Error: cannot divide by 0"
                } else (firstNum % secondNum).toString()

                else -> {
                    "Choose an operation"
                }
            }
            output.setText(result)
        }
    }




    // Set a listener for the RadioGroup

}