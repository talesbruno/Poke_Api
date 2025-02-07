package com.example.pokeapi.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokeapi.presentation.screens.detailScreen.DetailScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(
                    onItemClick = {
                        navController.navigate(Screen.DetailScreen.createRoute(it))
                    }
                )
            }
            composable(
                route = Screen.DetailScreen.route,
                arguments = listOf(navArgument("name") { type = NavType.StringType })
            ) { backStackEntry ->
                backStackEntry.arguments?.getString("name")?.let {
                    DetailScreen(
                        name = it,
                        onBackClick = { navController.popBackStack() })
                }
            }
        }
    }
}