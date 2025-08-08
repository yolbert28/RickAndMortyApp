package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.EpisodeResultModel

data class EpisodeResult(
    val count: Int,
    val pages: Int,
    val next: Int?,
    val prev: Int?,
    val episodes: List<Episode>
)
