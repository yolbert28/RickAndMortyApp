package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.domain.model.Episode
import javax.inject.Inject

class GetEpisodeByIdUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(id: Int): Episode? {
        return repository.getEpisodeById(id)
    }
}