package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.LocationResultModel

data class LocationResult(
    val count: Int,
    val pages: Int,
    val next: Int?,
    val prev: Int?,
    val locations: List<Location>
)

fun LocationResultModel.toDomain() = LocationResult(
    count = info.count,
    pages = info.pages,
    next = try { info.next?.toInt() } catch (e: Exception) { null },
    prev = try { info.prev?.toInt() } catch (e: Exception) { null },
    locations = results.map { it.toDomain() }
)