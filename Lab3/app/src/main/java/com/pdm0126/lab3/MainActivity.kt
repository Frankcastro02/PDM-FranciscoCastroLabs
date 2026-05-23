package com.pdm0126.lab3

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var acelerometro: Sensor? = null
    private val _sensorData = mutableStateOf("Esperando datos...")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            val listaNombres = remember { mutableStateListOf<String>() }

            NavHost(navController = navController, startDestination = "home") {

                composable("home") {
                    HomeScreen(
                        onNavigateToList = { navController.navigate("lista") },
                        onNavigateToSensors = { navController.navigate("sensores") }
                    )
                }

                composable("lista") {
                    ListaScreen(lista = listaNombres)
                }

                // PANTALLA SENSORES
                composable("sensores") {
                    SensorScreen(data = _sensorData.value)
                }
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            _sensorData.value = "X: ${event.values[0].format(2)}\n" +
                    "Y: ${event.values[1].format(2)}\n" +
                    "Z: ${event.values[2].format(2)}"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    override fun onResume() { super.onResume(); acelerometro?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI) } }
    override fun onPause() { super.onPause(); sensorManager.unregisterListener(this) }
}

@Composable
fun HomeScreen(onNavigateToList: () -> Unit, onNavigateToSensors: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Menú Principal", style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onNavigateToList, modifier = Modifier.fillMaxWidth(0.7f)) {
            Text("Ver Lista de Nombres")
        }
        Button(onClick = onNavigateToSensors, modifier = Modifier.fillMaxWidth(0.7f)) {
            Text("Ver Sensores")
        }
    }
}

@Composable
fun ListaScreen(lista: MutableList<String>) {
    val nombre = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(32.dp).padding(top = 20.dp)) {
        TextField(
            value = nombre.value,
            onValueChange = { nombre.value = it },
            placeholder = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            if(nombre.value.isNotBlank()) { lista.add(nombre.value); nombre.value = "" }
        }) { Text("Guardar") }

        LazyColumn(
            modifier = Modifier.fillMaxSize().border(2.dp, Color.Red, RoundedCornerShape(8.dp))
        ) {
            itemsIndexed(lista) { index, item ->
                Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                    Text("$item - Posición: ${index + 1}")
                }
            }
        }
    }
}

@Composable
fun SensorScreen(data: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Datos del Acelerómetro", style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = data, style = androidx.compose.ui.text.TextStyle(fontSize = 30.sp))
    }
}

fun Float.format(digits: Int) = "%.${digits}f".format(this)