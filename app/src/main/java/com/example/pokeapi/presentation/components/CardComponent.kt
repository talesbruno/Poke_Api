package com.example.pokeapi.presentation.components

import androidx.compose.runtime.Composable
import com.example.pokeapi.util.Constants

@Composable
fun CardComponent(
    url: String,
    title: String? = null,
    onItemClick: (String) -> Unit
) {
    val pokemonId = url.split("/")[6]

    if (title != null) {
        PokemonCard(
            title,
            "${Constants.BASE_SPRITE_URL}${pokemonId}.png",
            null,
            null,
            onItemClick
        )
    }
}