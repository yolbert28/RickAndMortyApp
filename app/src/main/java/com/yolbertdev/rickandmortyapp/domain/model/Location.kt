package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.LocationModel

data class Location (
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Int>,
)