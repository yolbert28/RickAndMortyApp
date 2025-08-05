package com.yolbertdev.rickandmortyapp.ui.model

data class LocationUiModel(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Int>,
)