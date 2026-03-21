package com.example.ejercicio1

import android.util.Log

class Computadora(
    //Properties
    var RAM: Int,
    var SSD: Int,
    var System: String,
    var Programas: List<String>
){
    fun TurnON(){
        Log.d("PRUEBA", "Computadora encendida")
    }

    fun TurnOFF(){
        Log.d("PRUEBA", "Computadora apagada")
    }

    fun Update(NRAM:Int, NSSD: Int, NSO: String){
        RAM = NRAM
        SSD = NSSD
        System = NSO
        Log.d("PRUEBA", "Computadora actualizada")

    }

    fun obtenerProgramas(){
        Log.d("PRUEBA", Programas.toString())
    }
}