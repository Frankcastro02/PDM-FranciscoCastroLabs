package com.example.ejercicio2

fun main(){
    val calc = Calculadora(
        marca = "Samsung",
        aniosDeVida = 5,
        precio = 25.99
    )

    println("--- Calculadora ${calc.marca} ---")
    println("--- Calculadora ${calc.aniosDeVida} ---")
    println("--- Calculadora ${calc.precio} ---")

    println("--- Operaciones ---")
    println("10 + 5 = ${calc.sumar(a = 10.0, b = 5.0)}")
    println("10 - 5 = ${calc.restar(a = 10.0, b = 5.0)}")
    println("10 * 5 = ${calc.multiplicar(a = 10.0, b = 5.0)}")
    println("10 / 5 = ${calc.dividir(a = 10.0, b = 5.0)}")
}