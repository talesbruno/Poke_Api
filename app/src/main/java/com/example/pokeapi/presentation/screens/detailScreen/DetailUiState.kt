package com.example.pokeapi.presentation.screens.detailScreen

import com.example.pokeapi.domain.model.Pokemon

data class DetailUiState(
    val isLoading: Boolean = false,
    val pokemons: Pokemon? = null,
    val error: String = "",
)