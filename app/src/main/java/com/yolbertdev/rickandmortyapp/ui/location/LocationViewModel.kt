package com.yolbertdev.rickandmortyapp.ui.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yolbertdev.rickandmortyapp.domain.GetLocationsUseCase
import com.yolbertdev.rickandmortyapp.domain.model.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getLocationsUseCase: GetLocationsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LocationUiState())
    val uiState: StateFlow<LocationUiState> = _uiState

    init {
        getLocations()
    }

    fun getLocations(page: Int = 1) {
        viewModelScope.launch {
            val result = getLocationsUseCase(page)

            _uiState.update {
                it.copy(
                    pages = result.pages,
                    next = result.next,
                    currentPage = page,
                    prev = result.prev,
                    locations = result.locations
                )
            }
        }
    }
}


data class LocationUiState(
    val pages: Int? = null,
    val next: Int? = null,
    val currentPage: Int = 1,
    val prev: Int? = null,
    val locations: List<Location> = emptyList()
)