package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult
import com.yolbertdev.rickandmortyapp.domain.model.DataError
import com.yolbertdev.rickandmortyapp.domain.model.Result
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(page: Int): Result<CharacterResult, DataError.Network> {
        return repository.getAllCharacters(page)
    }

}