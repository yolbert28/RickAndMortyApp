package com.yolbertdev.rickandmortyapp.ui.model

data class EpisodeUiModel(
    val id: Int,
    val name: String,
    val episode: String,
    val airDate: String,
    val characters: List<Int>,
)