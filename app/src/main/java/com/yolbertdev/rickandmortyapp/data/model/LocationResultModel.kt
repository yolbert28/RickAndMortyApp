package com.yolbertdev.rickandmortyapp.data.model

import com.yolbertdev.rickandmortyapp.domain.model.LocationResult

data class LocationResultModel(
    val info: Info,
    val results: List<LocationModel>
) {

    fun toDomain() = LocationResult(
        count = info.count,
        pages = info.pages,
        next = try { info.next?.toInt() } catch (e: Exception) { null },
        prev = try { info.prev?.toInt() } catch (e: Exception) { null },
        locations = results.map { it.toDomain() }
    )

}
