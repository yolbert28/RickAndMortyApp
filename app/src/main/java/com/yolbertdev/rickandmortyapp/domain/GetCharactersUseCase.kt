package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.data.RickAndMortyRepository
import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(page: Int): CharacterResult {
        return repository.getAllCharacters(page)
    }

}