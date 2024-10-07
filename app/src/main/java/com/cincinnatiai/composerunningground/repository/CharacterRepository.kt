package com.cincinnatiai.composerunningground.repository

import com.cincinnatiai.composerunningground.api.CharacterApi
import com.cincinnatiai.composerunningground.data.CharacterModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface CharacterRepository {

    suspend fun fetchCharacters(page: Int): List<CharacterModel>
}

class CharacterRepositoryImpl(
    private val api: CharacterApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : CharacterRepository {

    @Volatile
    private var isLoadable = true

    override suspend fun fetchCharacters(page: Int): List<CharacterModel> = withContext(dispatcher) {
        if (isLoadable) {
            val data = api.fetchCharacters(page)
            if (data.info.next.isNullOrEmpty()) {
                isLoadable = false
            }
            return@withContext data.results
        }
        return@withContext emptyList()
    }

}