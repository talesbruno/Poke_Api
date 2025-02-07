package com.example.pokeapi.di

import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.data.repository.PokemonsRepositoryImpl
import com.example.pokeapi.domain.repository.PokemonsRepository
import com.example.pokeapi.domain.useCase.GetPokemonByNameUseCase
import com.example.pokeapi.domain.useCase.GetPokemonsUseCase
import com.example.pokeapi.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Provides
    @Singleton
    fun providesConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideCurrencyService(retrofit: Retrofit): PokeApi =
        retrofit.create(PokeApi::class.java)

    @Provides
    @Singleton
    fun providesPokeApi(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providesPokemonsRepository(pokeApi: PokeApi): PokemonsRepository =
        PokemonsRepositoryImpl(pokeApi)

    @Provides
    fun provideGetAllPokemonsUseCase(pokemonsRepository: PokemonsRepository) =
        GetPokemonsUseCase(pokemonsRepository)

    @Provides
    fun providePokemonByNameUseCase(pokemonsRepository: PokemonsRepository) =
        GetPokemonByNameUseCase(pokemonsRepository)

}