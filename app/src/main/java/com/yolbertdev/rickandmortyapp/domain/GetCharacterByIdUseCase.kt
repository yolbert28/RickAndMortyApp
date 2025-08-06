package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.data.RickAndMortyRepository
import com.yolbertdev.rickandmortyapp.domain.model.Character
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(id: Int): Character? {
        return repository.getCharacterById(id)
    }

}