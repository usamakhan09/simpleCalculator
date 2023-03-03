package com.example.calculator
class CalculatorModel {
    private val operands = mutableListOf<Double>()
    private val operations = mutableListOf<String>()

    fun addOperand(operand: Double) {
        operands.add(operand)
    }

    fun addOperation(operation: String) {
        operations.add(operation)
    }

    fun clear() {
        operands.clear()
        operations.clear()
    }

    fun calculateResult(): Double {
        var result = operands[0]
        for (i in 0 until operations.size) {
            val op = operations[i]
            val op2 = operands[i + 1]
            result = when (op) {
                "+" -> result + op2
                "-" -> result - op2
                "*" -> result * op2
                "/" -> result / op2
                "%" -> result % op2
                else -> throw IllegalArgumentException("Invalid operation: $op")
            }
        }
        return result
    }
}
