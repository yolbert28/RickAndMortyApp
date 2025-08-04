package com.yolbertdev.rickandmortyapp.ui.prueba

import androidx.lifecycle.ViewModel
import com.yolbertdev.rickandmortyapp.inyecta.Inyectando
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ComponenteViewModel @Inject constructor(
    private val inyectando: Inyectando
) : ViewModel() {

    private val _uiState = MutableStateFlow("")
    val uiState: StateFlow<String> = _uiState

    fun getGreeting(){
        _uiState.update {
            inyectando.Greeting()
        }
    }
}