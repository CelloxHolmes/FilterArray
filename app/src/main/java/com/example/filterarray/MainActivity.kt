package com.example.filterarray

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var button: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        button = findViewById(R.id.button)
        resultTextView = findViewById(R.id.resultTextView)

        button.setOnClickListener {
            val numbers1 = input1.text.toString().split(",").map { it.trim().toInt() }
            val numbers2 = input2.text.toString().split(",").map { it.trim().toInt() }

            val result = mutableListOf<Int>()
            for (number in numbers1) {
                for (number2 in numbers2) {
                    if (number == number2) {
                        result.add(number)
                        break
                    }
                }
            }

            resultTextView.text = result.joinToString(", ")
        }
    }
}
