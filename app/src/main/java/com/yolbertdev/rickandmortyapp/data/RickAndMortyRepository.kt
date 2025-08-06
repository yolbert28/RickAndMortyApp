package com.yolbertdev.rickandmortyapp.data

import com.yolbertdev.rickandmortyapp.data.network.RickAndMortyService
import com.yolbertdev.rickandmortyapp.domain.model.Character
import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult
import com.yolbertdev.rickandmortyapp.domain.model.Episode
import com.yolbertdev.rickandmortyapp.domain.model.EpisodeResult
import com.yolbertdev.rickandmortyapp.domain.model.Location
import com.yolbertdev.rickandmortyapp.domain.model.LocationResult
import com.yolbertdev.rickandmortyapp.domain.model.toDomain
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val service: RickAndMortyService
) {

    suspend fun getAllCharacters(page: Int): CharacterResult {
        return service.getAllCharacters(page).toDomain()
    }

    suspend fun getCharacterById(id: Int): Character? {
        return service.getCharacterById(id)?.toDomain()
    }

    suspend fun getAllEpisodes(page: Int): EpisodeResult {
        return service.getAllEpisodes(page).toDomain()
    }

    suspend fun getEpisodeById(id: Int): Episode? {
        return service.getEpisodeById(id)?.toDomain()
    }

    suspend fun getAllLocations(id: Int): LocationResult {
        return service.getAllLocations(id).toDomain()
    }

    suspend fun getLocationById(id: Int): Location? {
        return service.getLocationById(id)?.toDomain()
    }

}