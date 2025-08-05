package com.yolbertdev.rickandmortyapp.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yolbertdev.rickandmortyapp.domain.GetCharactersUseCase
import com.yolbertdev.rickandmortyapp.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow(CharacterUiState(
        pages = null,
        next = null,
        prev = null,
        characters = emptyList()
    ))
    val uiState: StateFlow<CharacterUiState> = _uiState

    fun getCharacters(){
        viewModelScope.launch {
            val result = getCharactersUseCase()

            _uiState.update {
                it.copy(
                    pages = result.pages,
                    next = result.next,
                    prev = result.prev,
                    characters = result.characters
                )
            }
        }
    }

}

data class CharacterUiState (
    val pages: Int?,
    val next: Int?,
    val prev: Int?,
    val characters: List<Character>
)