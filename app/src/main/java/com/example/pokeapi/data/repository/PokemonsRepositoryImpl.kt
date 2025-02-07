package com.example.pokeapi.data.repository

import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.domain.model.Pokemon
import com.example.pokeapi.domain.model.PokemonList
import com.example.pokeapi.domain.repository.PokemonsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.pokeapi.util.Result
import javax.inject.Inject

class PokemonsRepositoryImpl @Inject constructor(private val pokeApi: PokeApi) :
    PokemonsRepository {
    override suspend fun getAllPokemons(limit: Int, offset: Int): Flow<Result<PokemonList>> {
        return flow {
            emit(Result.Loading())
            try {
                val response = pokeApi.getAllPokemons(limit, offset)
                emit(Result.Success(response))
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }
    }

    override suspend fun getPokemonByName(pokemonName: String): Flow<Result<Pokemon>> {
        return flow {
            emit(Result.Loading())
            try {
                val response = pokeApi.getPokemonByName(pokemonName)
                emit(Result.Success(response))
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }
    }

}