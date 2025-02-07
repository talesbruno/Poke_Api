package com.example.pokeapi.presentation.screens.home

sealed class Screen(val route: String){
    data object HomeScreen : Screen(route = "home_screen")
    data object DetailScreen : Screen(route = "detail_screen/{name}"){
        fun createRoute(name: String) = "detail_screen/$name"
    }
}