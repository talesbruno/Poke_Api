package com.example.pokeapi.presentation.screens.detailScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapi.domain.useCase.GetPokemonByNameUseCase
import com.example.pokeapi.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonByNameUseCase: GetPokemonByNameUseCase
) : ViewModel() {
    private val _state = mutableStateOf(DetailUiState())
    val state: State<DetailUiState> = _state

    fun getPokemon(name: String){
        viewModelScope.launch {
            getPokemonByNameUseCase(name).collect { result ->
                when (result) {
                    is Result.Error -> {
                        _state.value = DetailUiState(error = result.message ?: "Error!")
                    }
                    is Result.Loading -> {
                        _state.value = DetailUiState(isLoading = true)
                    }
                    is Result.Success -> {
                        _state.value = DetailUiState(pokemons = result.data)
                    }
                }
            }
        }
    }
}