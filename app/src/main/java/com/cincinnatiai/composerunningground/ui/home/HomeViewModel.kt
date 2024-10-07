package com.cincinnatiai.composerunningground.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cincinnatiai.composerunningground.repository.CharacterRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    @Volatile
    private var currentPage: Int = 1

    fun initialize() {
        viewModelScope.launch {
            val characters = characterRepository.fetchCharacters(currentPage)
            currentPage++
        }
    }

}