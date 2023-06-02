package com.example.solvethis

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var firstOperand = 0
    private var secondOperand = 0
    private var operationSign = ""
    private var totalCounter = 0
    private var correctCounter = 0
    private var wrongCounter = 0
    private var correctAnswer = 0
    private lateinit var firstOperandLabel: TextView
    private lateinit var secondOperandLabel: TextView
    private lateinit var operationLabel: TextView
    private lateinit var totalAmountLabel: TextView
    private lateinit var percentageCorrectLabel: TextView
    private lateinit var correctAmountLabel: TextView
    private lateinit var wrongAmountLabel: TextView
    private lateinit var userAnswerLabel: EditText
    private lateinit var btnCheck: Button
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstOperandLabel = findViewById(R.id.textFirstOperand)
        secondOperandLabel = findViewById(R.id.textSecondOperand)
        operationLabel = findViewById(R.id.textOperation)
        totalAmountLabel = findViewById(R.id.textTotalCounter)
        percentageCorrectLabel = findViewById(R.id.textPercentageCorrect)
        correctAmountLabel = findViewById(R.id.textRightCounter)
        wrongAmountLabel = findViewById(R.id.textWrongCounter)
        userAnswerLabel = findViewById(R.id.editTextAnswer)
        btnCheck = findViewById(R.id.btnCheck)
        btnStart = findViewById(R.id.btnStart)
    }

    fun btnStartClick(view: View) {
        firstOperand = Random.nextInt(10, 100)
        secondOperand = Random.nextInt(10, 100)

        firstOperandLabel.text  = firstOperand.toString()
        secondOperandLabel.text = secondOperand.toString()

        var operation: Int = if (firstOperand % secondOperand == 0) {
            Random.nextInt(1, 5)
        } else {
            Random.nextInt(1, 4)
        }
        when (operation)
        {
            1 -> { operationSign = "+"
                correctAnswer = firstOperand + secondOperand
            }
            2 -> { operationSign = "-"
                correctAnswer = firstOperand - secondOperand
            }
            3 -> { operationSign = "*"
                correctAnswer = firstOperand * secondOperand
            }
            4 -> { operationSign = "/"
                correctAnswer = firstOperand / secondOperand
            }
        }

        operationLabel.text = operationSign

        btnCheck.isEnabled = true
        btnStart.isEnabled = false
    }
    @SuppressLint("SetTextI18n")
    fun btnCheckClick(view: View) {
        totalCounter++
        totalAmountLabel.text = totalCounter.toString()

        if (userAnswerLabel.text.toString() == correctAnswer.toString())
        {
            correctCounter++
            correctAmountLabel.text = correctCounter.toString()
        }
        else
        {
            wrongCounter++
            wrongAmountLabel.text = wrongCounter.toString()
        }

        percentageCorrectLabel.text = String.format("%.2f", correctCounter.toDouble() / totalCounter.toDouble() * 100) + "%"

        btnCheck.isEnabled = false
        btnStart.isEnabled = true
    }
}