package com.example.example1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberEditText = findViewById(R.id.firstNumber)
        secondNumberEditText = findViewById(R.id.secondNumber)
        resultTextView = findViewById(R.id.resultText)

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            calculate('+')
            val SubButton: Button = findViewById(R.id.subtractButton)
            SubButton.setOnClickListener {
                calculate('-')
                val MultiButton: Button = findViewById(R.id.multiplyButton)
                MultiButton.setOnClickListener {
                    calculate('*')
                    val DivButton: Button = findViewById(R.id.divisionButton)
                    DivButton.setOnClickListener {
                        calculate('/')
                    }

                }
            }
        }
    }

    private fun calculate(operator: Char) {
        val firstNumber = firstNumberEditText.text.toString().toDouble()
        val secondNumber = secondNumberEditText.text.toString().toDouble()

        val result = when (operator) {
            '+' -> firstNumber + secondNumber
            '-' -> firstNumber - secondNumber
            '*' -> firstNumber * secondNumber
            '/' -> if (secondNumber != 0.0) firstNumber / secondNumber else Double.NaN
            else -> Double.NaN
        }

        resultTextView.text = "Result: $result"
    }
}
