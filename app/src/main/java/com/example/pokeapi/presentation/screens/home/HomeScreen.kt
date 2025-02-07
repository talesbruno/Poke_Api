package com.example.pokeapi.presentation.screens.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokeapi.presentation.components.CardComponent
import com.example.pokeapi.presentation.components.SearchBar
import com.example.pokeapi.presentation.screens.errorScreen.ErrorScreen
import com.example.pokeapi.presentation.screens.progressbarScreen.Progressbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = homeViewModel.state.value
    var searchQuery by remember { mutableStateOf("") }

    val filteredPokemons = state.pokemons.filter { pokemon ->
        pokemon.name.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Home" , color = Color.White) },
                colors = topAppBarColors(MaterialTheme.colorScheme.primary)
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                SearchBar(
                    modifier = Modifier
                        .padding(16.dp),
                    hint = "Buscar Pokémon...",
                    onSearch = { query ->
                        searchQuery = query
                    }
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(filteredPokemons) { pokemon ->
                        CardComponent(
                            url = pokemon.url,
                            title = pokemon.name,
                            onItemClick = onItemClick
                        )
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
    )
}