package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.data.RickAndMortyRepository
import com.yolbertdev.rickandmortyapp.domain.model.LocationResult
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(page: Int): LocationResult {
        return repository.getAllLocations(page)
    }

}