package com.yolbertdev.rickandmortyapp.data.network

import com.yolbertdev.rickandmortyapp.data.model.CharacterResultModel
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApiClient {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterResultModel>

}