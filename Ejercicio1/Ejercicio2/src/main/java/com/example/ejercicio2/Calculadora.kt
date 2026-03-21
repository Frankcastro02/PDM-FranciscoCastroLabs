package com.example.ejercicio2


class Calculadora(

    val marca: String,

    val aniosDeVida: Int
){
    var precio: Double

    init {
        precio = 0.0
    }

    constructor(marca: String, aniosDeVida: Int, precio: Double) : this(marca, aniosDeVida) {
    }
    fun sumar(a: Double, b: Double): Double{
        return a + b
    }

    fun restar(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    fun dividir(a: Double, b: Double) : Double {
        if (b == 0.0){
            println("Error: no se puede dividir entre cero")
            return 0.0
        }
        return a / b
    }
}