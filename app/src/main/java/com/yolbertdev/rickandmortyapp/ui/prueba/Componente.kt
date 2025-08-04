package com.yolbertdev.rickandmortyapp.ui.prueba

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Componente(viewModel: ComponenteViewModel = viewModel()) {

    viewModel.getGreeting()

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    Text(
        uiState.value
    )

}