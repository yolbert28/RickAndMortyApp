package com.yolbertdev.rickandmortyapp.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yolbertdev.rickandmortyapp.domain.GetCharactersUseCase
import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult
import com.yolbertdev.rickandmortyapp.domain.model.DataError
import com.yolbertdev.rickandmortyapp.domain.model.Result
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


    private val _uiState = MutableStateFlow(CharacterUiState())
    val uiState: StateFlow<CharacterUiState> = _uiState


    init {
        getCharacters()
    }

    fun onChangePage(page: Int) {
        getCharacters(page)
    }

    fun getCharacters(page: Int = 1){
        viewModelScope.launch {
            val result = getCharactersUseCase(page)

            _uiState.update {
                it.copy(
                    currentPage = page,
                    data = result
                )
            }
        }
    }

}

data class CharacterUiState (
    val currentPage: Int = 0,
    val data: Result<CharacterResult, DataError.Network> = Result.Loading
)