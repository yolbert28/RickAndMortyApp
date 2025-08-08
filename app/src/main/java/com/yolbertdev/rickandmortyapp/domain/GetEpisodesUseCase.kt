package com.yolbertdev.rickandmortyapp.domain

import com.yolbertdev.rickandmortyapp.domain.model.EpisodeResult
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(page: Int): EpisodeResult {
        return repository.getAllEpisodes(page)
    }

}