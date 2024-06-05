package com.l0122012.alfathroziq.ppab_11_l0122012_alfathroziqwidhayaka

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class KalkulatorActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var resultTextView: TextView
    private var operand: Double? = null
    private var pendingOperation = "="
    private var userIsInMiddleOfTyping = false

    private val decimalFormat = DecimalFormat("#.########")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        window.statusBarColor = getColor(android.R.color.transparent)
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.isAppearanceLightStatusBars = true

        resultTextView = findViewById(R.id.result)

        val numberButtons = listOf(
            R.id.button_0, R.id.button_1, R.id.button_2,
            R.id.button_3, R.id.button_4, R.id.button_5,
            R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9
        )

        val operationButtons = listOf(
            R.id.button_add, R.id.button_subtract, R.id.button_multiply, R.id.button_divide, R.id.button_equals
        )

        val clearButton: Button = findViewById(R.id.button_clear)
        clearButton.setOnClickListener {
            operand = null
            pendingOperation = "="
            resultTextView.text = "0"
            userIsInMiddleOfTyping = false
        }

        val dotButton: Button = findViewById(R.id.button_dot)
        dotButton.setOnClickListener {
            val resultText = resultTextView.text.toString()
            if (!resultText.contains(".")) {
                resultTextView.append(".")
                userIsInMiddleOfTyping = true
            }
        }

        val listener = View.OnClickListener { v ->
            val button = v as Button
            val text = button.text.toString()
            if (userIsInMiddleOfTyping) {
                resultTextView.append(text)
            } else {
                resultTextView.text = text
                userIsInMiddleOfTyping = true
            }
        }

        for (buttonId in numberButtons) {
            findViewById<Button>(buttonId).setOnClickListener(listener)
        }

        val opListener = View.OnClickListener { v ->
            try {
                val value = resultTextView.text.toString().toDouble()
                val button = v as Button
                val operation = button.text.toString()
                performOperation(value, operation)
            } catch (e: NumberFormatException) {
                resultTextView.text = ""
            }
            userIsInMiddleOfTyping = false
        }

        for (buttonId in operationButtons) {
            findViewById<Button>(buttonId).setOnClickListener(opListener)
        }
    }

    private fun performOperation(value: Double, operation: String) {
        if (operand == null) {
            operand = value
        } else {
            if (pendingOperation == "=") {
                pendingOperation = operation
            }

            when (pendingOperation) {
                "=" -> operand = value
                "+" -> operand = viewModel.add(operand!!, value)
                "-" -> operand = viewModel.subtract(operand!!, value)
                "x" -> operand = viewModel.multiply(operand!!, value)
                "/" -> {
                    try {
                        operand = viewModel.divide(operand!!, value)
                    } catch (e: IllegalArgumentException) {
                        Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        resultTextView.text = decimalFormat.format(operand)
        pendingOperation = operation
    }
}