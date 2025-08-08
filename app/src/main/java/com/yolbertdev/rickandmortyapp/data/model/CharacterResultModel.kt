package com.yolbertdev.rickandmortyapp.data.model

import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult

data class CharacterResultModel(
    val info: Info,
    val results: List<CharacterModel>
) {

    fun toDomain() = CharacterResult(
        count = info.count,
        pages = info.pages,
        next = try { info.next?.toInt() } catch (e: Exception) { null },
        prev = try { info.prev?.toInt() } catch (e: Exception) { null },
        characters = results.map { it.toDomain() }
    )

}