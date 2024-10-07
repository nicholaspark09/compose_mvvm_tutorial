package com.cincinnatiai.composerunningground.data

data class CharacterModel(
    val id: Long,
    val name: String,
    val species: String,
    val image: String
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String? = null,
    val prev: String? = null
)

data class CharactersResponse(
    val info: Info,
    val results: List<CharacterModel>
)