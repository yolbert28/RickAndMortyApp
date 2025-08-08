package com.yolbertdev.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName
import com.yolbertdev.rickandmortyapp.domain.model.Episode

data class EpisodeModel(
    @SerializedName("air_date")
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
) {

    fun toDomain() = Episode(
        id = id,
        name = name,
        episode = episode,
        airDate = airDate,
        characters = characters.map {
            try {
                it.substringAfterLast("/").toInt()
            } catch (e: Exception) {
                0
            }
        }
    )

}