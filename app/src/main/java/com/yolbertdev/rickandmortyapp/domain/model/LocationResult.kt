package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.LocationResultModel

data class LocationResult(
    val count: Int,
    val pages: Int,
    val next: Int?,
    val prev: Int?,
    val locations: List<Location>
)
