package com.example.calculator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var displayTextView: TextView
    private val model = CalculatorModel()
    private lateinit  var backspaceButton:Button
    private lateinit var inputTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view)
        backspaceButton = findViewById<Button>(R.id.backspaceButton)
        inputTextView = findViewById<TextView>(R.id.display)
        displayTextView = findViewById(R.id.display)
    }

    override fun onClick(view: View) {
        val clickedButton = view as Button
        val buttonText = clickedButton.text.toString()
        backspaceButton.setOnClickListener {

            val inputText = displayTextView.text.toString()


            if (inputText.isNotEmpty()) {
                displayTextView.text = inputText.substring(0, inputText.length - 1)
            }
        }
        when {
            buttonText == "C" -> {
                displayTextView.text = "0"
                model.clear()
            }
            buttonText == "." -> {
                if (!displayTextView.text.contains(".")) {
                    displayTextView.append(".")
                }
            }
            buttonText == "=" -> {
                if (displayTextView.text.isNotEmpty()) {
                    val operand = displayTextView.text.toString().toDouble()
                    model.addOperand(operand)
                    val result = model.calculateResult()
                    displayTextView.text = result.toString()
                    model.clear()
                }
            }
            buttonText == "%"||buttonText == "+" || buttonText == "-" || buttonText == "*" || buttonText == "/" -> {
                if (displayTextView.text.isNotEmpty()) {
                    val operand = displayTextView.text.toString().toDouble()
                    model.addOperand(operand)
                    model.addOperation(buttonText)
                    displayTextView.text = "0"

                }
            }
            else -> {
                if (displayTextView.text == "0") {

                    displayTextView.text = buttonText
                } else {

                    displayTextView.append(buttonText)
                }
            }
        }
    }
}
