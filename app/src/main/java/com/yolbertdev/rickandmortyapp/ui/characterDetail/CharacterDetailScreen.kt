package com.yolbertdev.rickandmortyapp.ui.characterDetail

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.yolbertdev.rickandmortyapp.ui.core.components.DetailLayout
import com.yolbertdev.rickandmortyapp.ui.core.components.TextAnnotatedApp
import com.yolbertdev.rickandmortyapp.ui.core.components.TextApp

@Composable
fun CharacterDetailScreen(
    id: Int,
    viewModel: CharacterDetailViewModel = hiltViewModel(),
    navigateToLocation: (Int) -> Unit,
    navigateToHome: () -> Unit,
    navigateToEpisode: (Int) -> Unit,
    navigateBack: () -> Unit
) {

    viewModel.getCharacter(id)

    val character by viewModel.uiState.collectAsStateWithLifecycle()

    DetailLayout(
        navigateBack = navigateBack,
        navigateToHome = navigateToHome
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    MaterialTheme.colorScheme.primary
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(Modifier.height(30.dp))
                AsyncImage(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape),
                    model = character?.image,
                    contentDescription = character?.name,
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(20.dp))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    TextApp(
                        text = character?.name.orEmpty(),
                        fontSize = 40.sp,
                        lineHeight = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(Modifier.height(12.dp))
                    TextAnnotatedApp(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Origen: ")
                            }
                            append(character?.location?.name)
                        }, fontSize = 20.sp, color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(Modifier.height(12.dp))
                    TextAnnotatedApp(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Species: ")
                            }
                            append(character?.species)
                        }, color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(Modifier.height(12.dp))
                    TextAnnotatedApp(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Gender: ")
                            }
                            append(character?.gender)
                        }, color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(Modifier.height(12.dp))
                    TextAnnotatedApp(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Type: ")
                            }
                            append(character?.type)
                        }, color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(Modifier.height(12.dp))
                    TextAnnotatedApp(
                        modifier = Modifier.clickable {
                            navigateToLocation(character?.location?.id ?: 0)
                        }, text = buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Location: ")
                            }
                            withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                                append(character?.location?.name)
                            }
                        }, color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(Modifier.height(12.dp))
                    TextAnnotatedApp(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Character number: ")
                            }
                            append(character?.id.toString())
                        }, color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(Modifier.height(30.dp))
                    TextApp(
                        text = "Episodes: ",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(Modifier.height(25.dp))
                    LazyRow {
                        items(character?.episode ?: emptyList()) { character ->
                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 5.dp)
                                    .clip(RoundedCornerShape(10))
                                    .size(100.dp)
                                    .background(MaterialTheme.colorScheme.onSurfaceVariant)
                                    .border(
                                        2.dp,
                                        MaterialTheme.colorScheme.onSecondary,
                                        RoundedCornerShape(10)
                                    )
                                    .clickable {
                                        navigateToEpisode(character)
                                    }, contentAlignment = Alignment.Center
                            ) {
                                TextApp(
                                    text = "S01E${if (character > 9) character else "0$character"}",
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSecondary
                                )
                            }
                        }

                    }
                    Spacer(Modifier.height(10.dp))
                }

            }
        }

    }


}
