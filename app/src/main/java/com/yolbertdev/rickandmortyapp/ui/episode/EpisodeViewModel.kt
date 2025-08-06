package com.yolbertdev.rickandmortyapp.ui.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yolbertdev.rickandmortyapp.domain.GetEpisodesUseCase
import com.yolbertdev.rickandmortyapp.domain.model.Character
import com.yolbertdev.rickandmortyapp.domain.model.Episode
import com.yolbertdev.rickandmortyapp.domain.model.EpisodeResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getEpisodesUseCase: GetEpisodesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(EpisodeUiState())
    val uiState: StateFlow<EpisodeUiState> = _uiState

    init {
        getEpisodes()
    }

    fun getEpisodes(page: Int = 1) {
        viewModelScope.launch {
            val result = getEpisodesUseCase(page)

            _uiState.update {
                it.copy(
                    pages = result.pages,
                    next = result.next,
                    currentPage = page,
                    prev = result.prev,
                    episodes = result.episodes
                )
            }
        }
    }

}


data class EpisodeUiState (
    val pages: Int? = null,
    val next: Int? = null,
    val currentPage: Int = 1,
    val prev: Int? = null,
    val episodes: List<Episode> = emptyList()
)