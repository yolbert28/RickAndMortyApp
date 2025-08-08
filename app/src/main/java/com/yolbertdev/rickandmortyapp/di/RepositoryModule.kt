package com.yolbertdev.rickandmortyapp.di

import com.yolbertdev.rickandmortyapp.data.RickAndMortyRepository
import com.yolbertdev.rickandmortyapp.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
        rickAndMortyRepository: RickAndMortyRepository
    ): Repository

}