package com.yolbertdev.rickandmortyapp.ui.episodeDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yolbertdev.rickandmortyapp.ui.core.components.DetailLayout
import com.yolbertdev.rickandmortyapp.ui.core.components.TextAnnotatedApp
import com.yolbertdev.rickandmortyapp.ui.core.components.TextApp
import com.yolbertdev.rickandmortyapp.ui.model.EpisodeUiModel

@Composable
fun EpisodeDetailScreen(
    id: Int,
    navigateToCharacter: (Int) -> Unit,
    navigateToHome: () -> Unit,
    navigateBack: () -> Unit
) {

    val episode = EpisodeUiModel(
        id = 1,
        name = "Pilot",
        episode = "S01E01",
        airDate = "December 2, 2013",
        characters = listOf(
            1,
            2,
            35,
            38,
            62,
            92,
            127,
            144,
            158,
            175,
            179,
            181,
            239,
            249,
            271,
            338,
            394,
            395,
            435
        )
    )

    DetailLayout(
        navigateBack = navigateBack,
        navigateToHome = navigateToHome
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    MaterialTheme.colorScheme.primary
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(30.dp))
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                TextApp(
                    modifier = Modifier.fillMaxWidth(),
                    text = episode.episode,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(20.dp))
                TextAnnotatedApp(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Name: ")
                        }
                        append(episode.name)
                    },
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(20.dp))
                TextAnnotatedApp(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Air date: ")
                        }
                        append(episode.airDate)
                    },
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(30.dp))
                TextApp(
                    text = "Characters number: ",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(25.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3)
                ) {
                    items(episode.characters) { character ->
                        Box(
                            modifier = Modifier
                                .padding(5.dp)
                                .clip(RoundedCornerShape(10))
                                .size(100.dp)
                                .background(MaterialTheme.colorScheme.onSurfaceVariant)
                                .border(
                                    2.dp,
                                    MaterialTheme.colorScheme.onSecondary,
                                    RoundedCornerShape(10)
                                )
                                .clickable {
                                    navigateToCharacter(character)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            TextApp(
                                text = "$character",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }

                }
            }


        }

    }

}