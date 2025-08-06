package com.yolbertdev.rickandmortyapp.ui.episode

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yolbertdev.rickandmortyapp.R
import com.yolbertdev.rickandmortyapp.ui.core.components.CardEpisodeLoadingItemApp
import com.yolbertdev.rickandmortyapp.ui.core.components.Footer
import com.yolbertdev.rickandmortyapp.ui.core.components.ImageWithGlassOverlay
import com.yolbertdev.rickandmortyapp.ui.core.components.Layout
import com.yolbertdev.rickandmortyapp.ui.core.components.PaginationApp
import com.yolbertdev.rickandmortyapp.ui.core.navigation.CardEpisodeItemApp

@Composable
fun EpisodeScreen(
    viewModel: EpisodeViewModel = hiltViewModel(),
    onChangeTheme: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    navigateToHome: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Layout(onChangeTheme = onChangeTheme, navigateToHome = navigateToHome) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(innerPadding)
        ) {
            item(span = { GridItemSpan(3) }) {
                ImageWithGlassOverlay(
                    text = "Episodios",
                    image = painterResource(R.drawable.season1),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp)
                        .padding(bottom = 40.dp),
                    blurPaddingTop = 250.dp,
                    blurPaddingBottom = 350.dp
                )
            }

            if (uiState.pages != null) {
                items(uiState.episodes, key = { it.id }) { episode ->
                    CardEpisodeItemApp(
                        modifier = Modifier,
                        episode = episode
                    ) {
                        navigateToDetail(episode.id)
                    }
                }
            } else {
                items(20, key = { it }) {
                    CardEpisodeLoadingItemApp()
                }
            }
            item(span = { GridItemSpan(3) }) {
                PaginationApp(currentPage = uiState.currentPage, maxPages = uiState.pages ?: 0, onChangePage = { page: Int -> viewModel.getEpisodes(page) })
            }
            item(span = { GridItemSpan(3) }) {
                Footer()
            }
        }
    }
}