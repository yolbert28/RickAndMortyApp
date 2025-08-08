package com.yolbertdev.rickandmortyapp.data.model

import com.yolbertdev.rickandmortyapp.domain.model.EpisodeResult

data class EpisodeResultModel(
    val info: Info,
    val results: List<EpisodeModel>
) {

    fun toDomain() = EpisodeResult(
        count = info.count,
        pages = info.pages,
        next = try { info.next?.toInt() } catch (e: Exception) { null },
        prev = try { info.prev?.toInt() } catch (e: Exception) { null },
        episodes = results.map { it.toDomain() }
    )

}