package com.yolbertdev.rickandmortyapp.ui.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object Character

@Serializable
object Episode

@Serializable
object Location

@Serializable
data class CharacterDetail(val id: Int)

@Serializable
data class EpisodeDetail(val id: Int)

@Serializable
data class LocationDetail(val id: Int)
