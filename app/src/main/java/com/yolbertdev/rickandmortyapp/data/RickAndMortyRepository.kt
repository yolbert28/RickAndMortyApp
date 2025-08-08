package com.yolbertdev.rickandmortyapp.data

import com.yolbertdev.rickandmortyapp.data.model.CharacterResultModel
import com.yolbertdev.rickandmortyapp.data.network.RickAndMortyService
import com.yolbertdev.rickandmortyapp.domain.Repository
import com.yolbertdev.rickandmortyapp.domain.model.Character
import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult
import com.yolbertdev.rickandmortyapp.domain.model.DataError
import com.yolbertdev.rickandmortyapp.domain.model.Episode
import com.yolbertdev.rickandmortyapp.domain.model.EpisodeResult
import com.yolbertdev.rickandmortyapp.domain.model.Location
import com.yolbertdev.rickandmortyapp.domain.model.LocationResult
import com.yolbertdev.rickandmortyapp.domain.model.Result
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val service: RickAndMortyService
) : Repository {

    override suspend fun getAllCharacters(page: Int): Result<CharacterResult, DataError.Network> {
        val result = service.getAllCharacters(page)
        return when(result){
            is Result.Success<CharacterResultModel, DataError.Network> -> Result.Success<CharacterResult, DataError.Network>(result.data.toDomain())
            is Result.Error<CharacterResultModel, DataError.Network> -> Result.Error<CharacterResult, DataError.Network>(result.error)
            Result.Loading -> Result.Loading
        }
    }

    override suspend fun getCharacterById(id: Int): Character? {
        return service.getCharacterById(id)?.toDomain()
    }

    override suspend fun getAllEpisodes(page: Int): EpisodeResult {
        return service.getAllEpisodes(page).toDomain()
    }

    override suspend fun getEpisodeById(id: Int): Episode? {
        return service.getEpisodeById(id)?.toDomain()
    }

    override suspend fun getAllLocations(id: Int): LocationResult {
        return service.getAllLocations(id).toDomain()
    }

    override suspend fun getLocationById(id: Int): Location? {
        return service.getLocationById(id)?.toDomain()
    }

}