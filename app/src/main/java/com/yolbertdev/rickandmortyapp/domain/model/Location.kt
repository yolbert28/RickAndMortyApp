package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.LocationModel

data class Location (
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Int>,
)

fun LocationModel.toDomain() = Location(
    id = id,
    name = name,
    type = type,
    dimension = dimension,
    residents = residents.map { it.substringAfterLast("/").toInt() }
)