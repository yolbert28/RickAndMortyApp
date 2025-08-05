package com.yolbertdev.rickandmortyapp.data.network

import com.yolbertdev.rickandmortyapp.data.model.CharacterResultModel
import com.yolbertdev.rickandmortyapp.data.model.Info
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RickAndMortyService @Inject constructor(
    private val api: RickAndMortyApiClient
) {
    suspend fun getAllCharacters(): CharacterResultModel  {
        return withContext(context = Dispatchers.IO) {
            api.getAllCharacters().body() ?: CharacterResultModel(
                info = Info(0,"0",0,"0"),
                results = emptyList()
            )
        }
    }
}