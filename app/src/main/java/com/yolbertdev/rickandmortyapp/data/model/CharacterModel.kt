package com.yolbertdev.rickandmortyapp.data.model

import com.yolbertdev.rickandmortyapp.domain.model.Character
import com.yolbertdev.rickandmortyapp.domain.model.LocationC
import com.yolbertdev.rickandmortyapp.domain.model.OriginC

data class CharacterModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {

    fun toDomain() = Character (
        id = id,
        name = name,
        image = image,
        gender = gender,
        species = species,
        type = type,
        status = status,
        location = LocationC(
            id = try {
                location.url.substringAfterLast("/").toInt()
            } catch (e: Exception){
                0
            },
            name = location.name
        ),
        origin = OriginC(
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

}