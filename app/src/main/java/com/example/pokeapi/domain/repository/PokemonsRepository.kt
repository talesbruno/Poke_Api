package com.example.pokeapi.domain.repository

import com.example.pokeapi.domain.model.Pokemon
import com.example.pokeapi.domain.model.PokemonList
import com.example.pokeapi.util.Result
import kotlinx.coroutines.flow.Flow

interface PokemonsRepository {
    suspend fun getAllPokemons(limit: Int, offset: Int): Flow<Result<PokemonList>>
    suspend fun getPokemonByName(pokemonName: String): Flow<Result<Pokemon>>
}