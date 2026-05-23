package com.pdm0126.labo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdm0126.labo4.navigation.AppNavigation
import com.pdm0126.labo4.ui.theme.Labo4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo4Theme {
                AppNavigation()
            }
        }
    }
}
