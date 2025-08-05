package com.yolbertdev.rickandmortyapp.domain.model

import com.yolbertdev.rickandmortyapp.data.model.CharacterResultModel

data class CharacterResult (
    val count: Int,
    val pages: Int,
    val next: Int?,
    val prev: Int?,
    val characters: List<Character>
)

fun CharacterResultModel.toDomain() = CharacterResult(
    count = info.count,
    pages = info.pages,
    next = try { info.next?.toInt() } catch (e: Exception) { null },
    prev = try { info.prev?.toInt() } catch (e: Exception) { null },
    characters = results.map { it.toDomain() }
)