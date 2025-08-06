package com.yolbertdev.rickandmortyapp.ui.episodeDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yolbertdev.rickandmortyapp.domain.GetEpisodeByIdUseCase
import com.yolbertdev.rickandmortyapp.domain.model.Episode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val getEpisodeByIdUseCase: GetEpisodeByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Episode?>(null)
    val uiState: StateFlow<Episode?> = _uiState

    fun getEpisode(id: Int) {
        viewModelScope.launch {
            val result = getEpisodeByIdUseCase(id)

            _uiState.update {
                result
            }
        }
    }

}