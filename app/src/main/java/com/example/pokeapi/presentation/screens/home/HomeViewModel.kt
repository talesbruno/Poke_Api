package com.example.pokeapi.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pokeapi.domain.useCase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.pokeapi.util.Result
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(HomeUiState())
    val state: State<HomeUiState> = _state

    init {
        getPokemons(150, 150)
    }

    private fun getPokemons(limit: Int, offset: Int) {
        viewModelScope.launch {
            getPokemonsUseCase(limit, offset).collect { result ->
                when (result) {
                    is Result.Error -> {
                        _state.value = HomeUiState(error = result.message ?: "Error!")
                    }
                    is Result.Loading -> {
                        _state.value = HomeUiState(isLoading = true)
                    }
                    is Result.Success -> {
                        _state.value = HomeUiState(pokemons = result.data?.results ?: emptyList())
                    }
                }
            }
        }
    }
}