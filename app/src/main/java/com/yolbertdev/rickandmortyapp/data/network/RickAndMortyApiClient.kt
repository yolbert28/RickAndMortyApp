package com.yolbertdev.rickandmortyapp.data.network

import com.yolbertdev.rickandmortyapp.data.model.CharacterModel
import com.yolbertdev.rickandmortyapp.data.model.CharacterResultModel
import com.yolbertdev.rickandmortyapp.data.model.EpisodeModel
import com.yolbertdev.rickandmortyapp.data.model.EpisodeResultModel
import com.yolbertdev.rickandmortyapp.data.model.LocationModel
import com.yolbertdev.rickandmortyapp.data.model.LocationResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiClient {

    @GET("character/")
    suspend fun getAllCharacters(@Query("page") page: Int): Response<CharacterResultModel>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<CharacterModel>

    @GET("episode/")
    suspend fun getAllEpisodes(@Query("page") page: Int): Response<EpisodeResultModel>

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): Response<EpisodeModel>

    @GET("location/")
    suspend fun getAllLocations(@Query("page") page: Int): Response<LocationResultModel>

    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): Response<LocationModel>

}