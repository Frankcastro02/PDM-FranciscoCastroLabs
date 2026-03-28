package com.example.pdm_franciscocastrol2


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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val nombre: MutableState<String> = remember { mutableStateOf("") }
            val lista: MutableList<String> = remember { mutableStateListOf()  }

            Column(
                modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextField(
                    value = nombre.value,
                    onValueChange = { nombre.value = it},
                    placeholder =  {Text("Nombre")},
                    modifier = Modifier.fillMaxWidth()

                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                            lista.add(nombre.value)
                            nombre.value = ""
                    }
                ) {
                    Text("Guardar")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Listado de nombres y posiciones en la lista")
                    Button(
                        onClick = {lista.clear()}
                    ) {
                        Text("Limpiar")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .border(2.dp, Color.Red, RoundedCornerShape(8.dp))
                ) {
                    itemsIndexed(lista){ index, item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = item)
                            Text(text = (index + 1).toString())
                        }
                    }
                }
            }

        }
    }
}
