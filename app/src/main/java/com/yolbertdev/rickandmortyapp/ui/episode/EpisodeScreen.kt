package com.yolbertdev.rickandmortyapp.ui.episode

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yolbertdev.rickandmortyapp.R
import com.yolbertdev.rickandmortyapp.ui.core.components.Footer
import com.yolbertdev.rickandmortyapp.ui.core.components.ImageWithGlassOverlay
import com.yolbertdev.rickandmortyapp.ui.core.components.Layout
import com.yolbertdev.rickandmortyapp.ui.core.components.PaginationApp
import com.yolbertdev.rickandmortyapp.ui.core.navigation.CardEpisodeItemApp
import com.yolbertdev.rickandmortyapp.ui.model.EpisodeUiModel

@Composable
fun EpisodeScreen(
    onChangeTheme: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    navigateToHome: () -> Unit
) {

    val episodes = listOf(
        EpisodeUiModel(
            id = 1,
            name = "Pilot",
            episode = "S01E01",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 2,
            name = "Pilot",
            episode = "S01E02",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 3,
            name = "Pilot",
            episode = "S01E03",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 4,
            name = "Pilot",
            episode = "S01E04",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 5,
            name = "Pilot",
            episode = "S01E05",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 6,
            name = "Pilot",
            episode = "S01E06",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 7,
            name = "Pilot",
            episode = "S01E07",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 8,
            name = "Pilot",
            episode = "S01E08",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 9,
            name = "Pilot",
            episode = "S01E09",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 10,
            name = "Pilot",
            episode = "S01E10",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 11,
            name = "Pilot",
            episode = "S01E11",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 12,
            name = "Pilot",
            episode = "S01E12",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 13,
            name = "Pilot",
            episode = "S01E13",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 14,
            name = "Pilot",
            episode = "S01E14",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 15,
            name = "Pilot",
            episode = "S01E15",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 16,
            name = "Pilot",
            episode = "S01E16",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 17,
            name = "Pilot",
            episode = "S01E17",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 18,
            name = "Pilot",
            episode = "S01E18",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 19,
            name = "Pilot",
            episode = "S01E19",
            airDate = "December 2, 2013",
            characters = emptyList()
        ),
        EpisodeUiModel(
            id = 20,
            name = "Pilot",
            episode = "S01E20",
            airDate = "December 2, 2013",
            characters = emptyList()
        )
    )

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

            items(episodes, key = { it.id }) { episode ->
                CardEpisodeItemApp(
                    modifier = Modifier,
                    episode = episode
                ) {
                    navigateToDetail(episode.id)
                }
            }
            item(span = { GridItemSpan(3) }) {
                PaginationApp(navigateToBackPage = {}, navigateToNextPage = {})
            }
            item(span = { GridItemSpan(3) }) {
                Footer()
            }
        }
    }
}