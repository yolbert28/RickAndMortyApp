package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.EpisodeResultModel

data class EpisodeResult(
    val count: Int,
    val pages: Int,
    val next: Int?,
    val prev: Int?,
    val episodes: List<Episode>
)

fun EpisodeResultModel.toDomain() = EpisodeResult(
    count = info.count,
    pages = info.pages,
    next = try { info.next?.toInt() } catch (e: Exception) { null },
    prev = try { info.prev?.toInt() } catch (e: Exception) { null },
    episodes = results.map { it.toDomain() }
    )
