package com.example.pokeapi.data.api

import com.example.pokeapi.domain.model.Pokemon
import com.example.pokeapi.domain.model.PokemonList
import com.example.pokeapi.domain.model.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{pokemonName}/")
    suspend fun getPokemonByName(@Path("pokemonName") pokemonName: String?) : Pokemon

}