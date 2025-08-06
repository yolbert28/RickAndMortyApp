package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.data.RickAndMortyRepository
import com.yolbertdev.rickandmortyapp.domain.model.EpisodeResult
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    suspend operator fun invoke(page: Int): EpisodeResult {
        return repository.getAllEpisodes(page)
    }

}