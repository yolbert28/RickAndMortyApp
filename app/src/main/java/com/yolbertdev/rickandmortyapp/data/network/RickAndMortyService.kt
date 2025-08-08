package com.yolbertdev.rickandmortyapp.data.network

import com.yolbertdev.rickandmortyapp.data.model.CharacterModel
import com.yolbertdev.rickandmortyapp.data.model.CharacterResultModel
import com.yolbertdev.rickandmortyapp.data.model.EpisodeModel
import com.yolbertdev.rickandmortyapp.data.model.EpisodeResultModel
import com.yolbertdev.rickandmortyapp.data.model.Info
import com.yolbertdev.rickandmortyapp.data.model.LocationModel
import com.yolbertdev.rickandmortyapp.data.model.LocationResultModel
import com.yolbertdev.rickandmortyapp.domain.model.DataError
import com.yolbertdev.rickandmortyapp.domain.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class RickAndMortyService @Inject constructor(
    private val api: RickAndMortyApiClient
) {
    suspend fun getAllCharacters(page: Int): Result<CharacterResultModel, DataError.Network> {
        return withContext(context = Dispatchers.IO) {
            try {
                val response = api.getAllCharacters(page)

                if (response.isSuccessful) {
                    val body = response.body()

                    if (body != null)
                        Result.Success<CharacterResultModel, DataError.Network>(body)
                    else
                        Result.Loading
                } else {
                    when(response.code()){
                        400 -> Result.Error<CharacterResultModel, DataError.Network>(DataError.Network.BAD_REQUEST)
                        404 -> Result.Error<CharacterResultModel, DataError.Network>(DataError.Network.NOT_FOUND)
                        in 500..599 -> Result.Error<CharacterResultModel, DataError.Network>(DataError.Network.SERVER_ERROR)
                        else -> Result.Error<CharacterResultModel, DataError.Network>(DataError.Network.UNKNOWN)
                    }
                }
            } catch (e: HttpException){
                Result.Error<CharacterResultModel, DataError.Network>(DataError.Network.NO_INTERNET)
            } catch (e: Exception) {
                Result.Error<CharacterResultModel, DataError.Network>(DataError.Network.UNKNOWN)
            }

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
        return withContext(Dispatchers.IO) {
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