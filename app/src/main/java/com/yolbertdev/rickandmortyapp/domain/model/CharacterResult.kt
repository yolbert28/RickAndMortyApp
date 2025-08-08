package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.CharacterResultModel

data class CharacterResult (
    val count: Int,
    val pages: Int,
    val next: Int?,
    val prev: Int?,
    val characters: List<Character>
)
