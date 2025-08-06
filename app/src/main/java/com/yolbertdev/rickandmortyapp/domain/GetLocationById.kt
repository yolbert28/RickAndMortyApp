package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.data.RickAndMortyRepository
import com.yolbertdev.rickandmortyapp.domain.model.Location
import javax.inject.Inject

class GetLocationById @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(id: Int): Location? {
        return repository.getLocationById(id)
    }
}