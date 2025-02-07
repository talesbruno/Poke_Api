package com.example.pokeapi.presentation.screens.home


import com.example.pokeapi.domain.model.Result

data class HomeUiState(
    val isLoading: Boolean = false,
    val pokemons: List<Result> = emptyList(),
    val error: String = ""
)