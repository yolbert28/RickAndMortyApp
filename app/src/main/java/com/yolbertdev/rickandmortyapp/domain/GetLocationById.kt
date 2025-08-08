package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.domain.model.Location
import javax.inject.Inject

class GetLocationById @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(id: Int): Location? {
        return repository.getLocationById(id)
    }
}