package com.yolbertdev.rickandmortyapp.ui.locationDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yolbertdev.rickandmortyapp.domain.GetLocationById
import com.yolbertdev.rickandmortyapp.domain.model.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    private val getLocationById: GetLocationById
) : ViewModel() {

    private val _uiState = MutableStateFlow<Location?>(null)
    val uiState: StateFlow<Location?> = _uiState


    fun getLocation(id: Int) {
        viewModelScope.launch {
            val result = getLocationById(id)

            _uiState.update {
                result
            }
        }
    }
}