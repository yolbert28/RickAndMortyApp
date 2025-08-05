package com.yolbertdev.rickandmortyapp.ui.model

data class CharacterUiModel(
    val id: Int,
    val name: String,
    val image: String,
    val gender: String,
    val species: String,
    val status: String,
    val episode: List<Int>,
    val location: Location,
    val origin: Origin,
    val type: String,
)