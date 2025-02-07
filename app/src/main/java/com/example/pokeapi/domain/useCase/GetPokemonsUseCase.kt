package com.example.pokeapi.domain.useCase

import com.example.pokeapi.domain.repository.PokemonsRepository
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val pokemonsRepository: PokemonsRepository) {
    suspend operator fun invoke(limit: Int, offset: Int) =
        pokemonsRepository.getAllPokemons(limit, offset)
}