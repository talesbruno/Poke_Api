package com.example.pokeapi.domain.useCase

import com.example.pokeapi.domain.repository.PokemonsRepository
import javax.inject.Inject

class GetPokemonByNameUseCase @Inject constructor(private val pokemonsRepository: PokemonsRepository) {
    suspend operator fun invoke(pokemonName: String) = pokemonsRepository.getPokemonByName(pokemonName)
}