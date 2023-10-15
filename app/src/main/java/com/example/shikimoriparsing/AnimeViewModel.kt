package com.example.shikimoriparsing

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AnimeViewModel : ViewModel() {
    private val repository = AnimeRepository()

    val animeList = MutableStateFlow<List<Anime>>(emptyList())

    init {
        fetchAnimeList()
    }

    fun fetchAnimeList() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.fetchAnimeList()
            animeList.value = data
        }
    }
}