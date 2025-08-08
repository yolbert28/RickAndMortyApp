package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.domain.model.Character
import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult
import com.yolbertdev.rickandmortyapp.domain.model.DataError
import com.yolbertdev.rickandmortyapp.domain.model.Episode
import com.yolbertdev.rickandmortyapp.domain.model.EpisodeResult
import com.yolbertdev.rickandmortyapp.domain.model.Location
import com.yolbertdev.rickandmortyapp.domain.model.LocationResult
import com.yolbertdev.rickandmortyapp.domain.model.Result

interface Repository {

    suspend fun getAllCharacters(page: Int): Result<CharacterResult, DataError.Network>

    suspend fun getCharacterById(id: Int): Character?

    suspend fun getAllEpisodes(page: Int): EpisodeResult

    suspend fun getEpisodeById(id: Int): Episode?

    suspend fun getAllLocations(id: Int): LocationResult

    suspend fun getLocationById(id: Int): Location?

}