package com.example.ejercicio1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val programs = listOf("Notion 2026", "Facebook 2024", "Spotify 2026", "Chrome 2026")

        val compu = Computadora(
            RAM = 16,
            SSD = 256,
            System = "Windows",
            Programas = programs
        )

        //Encender
        compu.TurnON()

        //Datos iniciales
        Log.d("PRUEBA", "--- Datos iniciales ---")
        Log.d("PRUEBA", "RAM: ${compu.RAM} GB")
        Log.d("PRUEBA", "SSD: ${compu.SSD} GB")
        Log.d("PRUEBA", "SO: ${compu.System} GB")
        Log.d("PRUEBA", "Programas del 2025: ${compu.obtenerProgramas()}")

        //Actualizar
        compu.Update(NRAM = 32, NSSD = 512, NSO = "Ubuntu")
        Log.d("PRUEBA", "--- Despues de actualizar ---")
        Log.d("PRUEBA", "Nueva RAM: ${compu.RAM} GB")
        Log.d("PRUEBA", "Nueva SSD: ${compu.SSD} GB")
        Log.d("PRUEBA", "Nuevo SO: ${compu.System} GB")

        //Apagar
        compu.TurnOFF()
    }
}