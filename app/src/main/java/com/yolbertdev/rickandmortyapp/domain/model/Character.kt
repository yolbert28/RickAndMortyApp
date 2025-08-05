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
    val location: Location,
    val origin: Origin,
    val episode: List<Int>,
)

fun CharacterModel.toDomain() = Character (
    id = id,
    name = name,
    image = image,
    gender = gender,
    species = species,
    type = type,
    status = status,
    location = Location(
        id = try {
            origin.url.substringAfterLast("/").toInt()
        } catch (e: Exception){
            0
        },
        name = location.name
    ),
    origin = Origin(
        id = try {
            origin.url.substringAfterLast("/").toInt()
        } catch (e: Exception){
            0
        },
        name = origin.name
    ),
    episode = episode.map { try {
        it.substringAfterLast("/").toInt()
    } catch (e: Exception){
        0
    } }
)