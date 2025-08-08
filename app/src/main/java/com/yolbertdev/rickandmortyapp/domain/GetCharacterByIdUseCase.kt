package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.domain.model.Character
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(id: Int): Character? {
        return repository.getCharacterById(id)
    }

}