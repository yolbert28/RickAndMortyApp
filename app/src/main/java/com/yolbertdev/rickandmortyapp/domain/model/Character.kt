package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.CharacterModel

data class Character (
    val id: Int,
    val name: String,
    val image: String,
    val gender: String,
    val species: String,
    val type: String,
    val status: String,
    val location: LocationC,
    val origin: OriginC,
    val episode: List<Int>,
)