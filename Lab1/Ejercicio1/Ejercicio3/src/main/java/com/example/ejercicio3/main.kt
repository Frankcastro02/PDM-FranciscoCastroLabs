package com.example.ejercicio3

fun main() {
    val Ciclo1 = listOf(
        Estudiante("Francisco Castro", "00182724","Calculo"),
        Estudiante("Guillermo Herrera", "00098746","Calculo"),
        Estudiante("Josemaria Moran", "00098735","Calculo"),
        Estudiante("Luis Camono", "00283745","Calculo"),

        Estudiante("Marvin Selada", "00482956","Moviles"),
        Estudiante("Javier Vernia", "00098267","Moviles"),
        Estudiante("Maria Lopez", "00015389","Moviles"),
    )

    println("Estudiantes de Calculo")
    val Moviles = Ciclo1.filter {
        it.asignatura == "Calculo"
    }

    Moviles.forEach {
        println("Nombre: ${it.nombre} | Carnet: ${it.carnet}")
    }

    println("Total: ${Moviles.size} estudiantes")
}