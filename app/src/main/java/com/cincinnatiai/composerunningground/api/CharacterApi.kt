package com.cincinnatiai.composerunningground.api

import com.cincinnatiai.composerunningground.data.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface CharacterApi {

    @GET("character")
    suspend fun fetchCharacters(@Query("page") page: Int): CharactersResponse
}