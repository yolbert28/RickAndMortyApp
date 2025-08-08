package com.yolbertdev.rickandmortyapp.di

import com.yolbertdev.rickandmortyapp.data.network.RickAndMortyApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRickAndMortyClient(retrofit: Retrofit): RickAndMortyApiClient {
        return retrofit.create(RickAndMortyApiClient::class.java)
    }
}