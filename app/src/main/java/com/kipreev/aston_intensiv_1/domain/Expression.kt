package com.kipreev.aston_intensiv_1.domain

sealed class Expression {
    class Number(val numb: Double) : Expression()
    class Sum(val numb1: Number, val numb2: Number) : Expression()
}

class TestExpression {
    val numb = Expression.Number(1.3)
    val numb1 = Expression.Number(2.5)

    val sum = Expression.Sum(numb, numb1)

}

fun testExpression(expression: Expression): Double = when (expression) {
    is Expression.Number -> expression.numb
    is Expression.Sum -> testExpression(expression.numb1) + testExpression(expression.numb2)
}



