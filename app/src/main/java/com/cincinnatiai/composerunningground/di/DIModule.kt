package com.cincinnatiai.composerunningground.di

import com.cincinnatiai.composerunningground.api.CharacterApi
import com.cincinnatiai.composerunningground.repository.CharacterRepository
import com.cincinnatiai.composerunningground.repository.CharacterRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton
object DIModule {

    private val url = "https://rickandmortyapi.com/api/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val characterApi: CharacterApi by lazy {
        retrofit.create(CharacterApi::class.java)
    }

    val characterRepository: CharacterRepository by lazy {
        CharacterRepositoryImpl(characterApi)
    }
}