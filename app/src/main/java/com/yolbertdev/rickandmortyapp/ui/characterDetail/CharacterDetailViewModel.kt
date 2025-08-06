package com.yolbertdev.rickandmortyapp.ui.characterDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yolbertdev.rickandmortyapp.domain.GetCharacterByIdUseCase
import com.yolbertdev.rickandmortyapp.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Character?>(null)
    val uiState: StateFlow<Character?> = _uiState

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            val result = getCharacterByIdUseCase(id)

            _uiState.update {
                result
            }
        }
    }

}