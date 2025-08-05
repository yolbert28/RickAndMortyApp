package com.yolbertdev.rickandmortyapp.data

import com.yolbertdev.rickandmortyapp.data.network.RickAndMortyService
import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult
import com.yolbertdev.rickandmortyapp.domain.model.toDomain
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val api: RickAndMortyService
) {

    suspend fun getAllCharacters(): CharacterResult {
        return api.getAllCharacters().toDomain()
    }

}