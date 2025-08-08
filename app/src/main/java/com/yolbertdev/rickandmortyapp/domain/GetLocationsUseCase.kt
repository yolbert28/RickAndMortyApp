package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.domain.model.LocationResult
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(page: Int): LocationResult {
        return repository.getAllLocations(page)
    }

}