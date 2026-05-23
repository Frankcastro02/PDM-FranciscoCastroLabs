package com.pdm0126.labo4.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdm0126.labo4.view.HomeScreen
import com.pdm0126.labo4.view.TasksScreen
import com.pdm0126.labo4.viewmodel.TaskViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: TaskViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Tasks> {
            TasksScreen(viewModel = viewModel)
        }
    }
}
