package com.yolbertdev.rickandmortyapp.ui.location

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yolbertdev.rickandmortyapp.R
import com.yolbertdev.rickandmortyapp.ui.core.components.CardEpisodeLoadingItemApp
import com.yolbertdev.rickandmortyapp.ui.core.components.CardLocationItemApp
import com.yolbertdev.rickandmortyapp.ui.core.components.CardLocationLoadingItemApp
import com.yolbertdev.rickandmortyapp.ui.core.components.Footer
import com.yolbertdev.rickandmortyapp.ui.core.components.ImageWithGlassOverlay
import com.yolbertdev.rickandmortyapp.ui.core.components.Layout
import com.yolbertdev.rickandmortyapp.ui.core.components.PaginationApp
import com.yolbertdev.rickandmortyapp.ui.core.components.TextApp

@Composable
fun LocationScreen(
    viewModel: LocationViewModel = hiltViewModel(),
    onChangeTheme: () -> Unit,
    navigateToLocation: (Int) -> Unit,
    navigateToHome: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Layout(onChangeTheme = onChangeTheme, navigateToHome = navigateToHome) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            item() {
                ImageWithGlassOverlay(
                    text = "Locations",
                    image = painterResource(R.drawable.planet),
                    modifier = Modifier.fillMaxWidth().height(420.dp).padding(bottom = 40.dp),
                    blurPaddingTop = 250.dp,
                    blurPaddingBottom = 350.dp
                )
            }

            if(uiState.pages != null) {
                items(uiState.locations) { location ->
                    CardLocationItemApp(
                        location = location,
                        navigateToDetail = navigateToLocation
                    )
                }
            } else {
                items(20) {
                    CardLocationLoadingItemApp()
                }
            }
            item() {
                PaginationApp( currentPage = uiState.currentPage, maxPages = uiState.pages ?: 1, onChangePage = { page: Int -> viewModel.getLocations(page)})
                Footer()
            }
        }
    }
}