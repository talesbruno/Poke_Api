package com.example.pokeapi.presentation.screens.detailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokeapi.presentation.components.PokemonCard
import com.example.pokeapi.presentation.screens.errorScreen.ErrorScreen
import com.example.pokeapi.presentation.screens.progressbarScreen.Progressbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    name: String,
    detailViewModel: DetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    LaunchedEffect(Unit) {
        detailViewModel.getPokemon(name)
    }
    val state = detailViewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary),
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            state.pokemons?.sprites?.front_default?.let {
                state.pokemons.weight.let { it1 ->
                    state.pokemons.height.let { it2 ->
                        PokemonCard(
                            pokemonName = name,
                            imageUrl = it,
                            weight = it1,
                            height = it2
                        ) {}
                    }
                }
            }
            if (state.error.isNotBlank()) {
                ErrorScreen(state.error)
            }
            if (state.isLoading) {
                Progressbar()
            }
        }
    }

}