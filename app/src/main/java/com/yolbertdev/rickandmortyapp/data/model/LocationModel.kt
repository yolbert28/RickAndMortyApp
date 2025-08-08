package com.yolbertdev.rickandmortyapp.data.model

import com.yolbertdev.rickandmortyapp.domain.model.Location

data class LocationModel(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {

    fun toDomain() = Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents.map { it.substringAfterLast("/").toInt() }
    )

}