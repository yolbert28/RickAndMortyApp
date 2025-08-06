package com.yolbertdev.rickandmortyapp.data.network

import com.yolbertdev.rickandmortyapp.data.model.CharacterModel
import com.yolbertdev.rickandmortyapp.data.model.CharacterResultModel
import com.yolbertdev.rickandmortyapp.data.model.EpisodeModel
import com.yolbertdev.rickandmortyapp.data.model.EpisodeResultModel
import com.yolbertdev.rickandmortyapp.data.model.Info
import com.yolbertdev.rickandmortyapp.data.model.LocationModel
import com.yolbertdev.rickandmortyapp.data.model.LocationResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RickAndMortyService @Inject constructor(
    private val api: RickAndMortyApiClient
) {
    suspend fun getAllCharacters(page: Int): CharacterResultModel {
        return withContext(context = Dispatchers.IO) {
            api.getAllCharacters(page).body() ?: CharacterResultModel(
                info = Info(0, "0", 0, "0"),
                results = emptyList()
            )
        }
    }

    suspend fun getCharacterById(id: Int): CharacterModel? {
        return withContext(context = Dispatchers.IO) {
            api.getCharacterById(id).body()
        }
    }

    suspend fun getAllEpisodes(page: Int): EpisodeResultModel {
        return withContext(Dispatchers.IO) {
            api.getAllEpisodes(page).body() ?: EpisodeResultModel(
                info = Info(0, "0", 0, "0"),
                results = emptyList()
            )
        }
    }

    suspend fun getEpisodeById(id: Int): EpisodeModel? {
        return withContext(Dispatchers.IO) {
            api.getEpisodeById(id).body()
        }
    }

    suspend fun getAllLocations(page: Int): LocationResultModel {
        return withContext(Dispatchers.IO){
            api.getAllLocations(page).body() ?: LocationResultModel(
                info = Info(0, "0", 0, "0"),
                results = emptyList()
            )
        }
    }

    suspend fun getLocationById(id: Int): LocationModel? {
        return withContext(Dispatchers.IO) {
            api.getLocationById(id).body()
        }
    }

}