package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.EpisodeModel
import kotlin.collections.map

data class Episode(
    val id: Int,
    val name: String,
    val episode: String,
    val airDate: String,
    val characters: List<Int>
)
