package com.yolbertdev.rickandmortyapp.ui.locationDetail

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
import androidx.compose.runtime.getValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yolbertdev.rickandmortyapp.ui.core.components.DetailLayout
import com.yolbertdev.rickandmortyapp.ui.core.components.TextAnnotatedApp
import com.yolbertdev.rickandmortyapp.ui.core.components.TextApp

@Composable
fun LocationDetailScreen(
    id: Int,
    viewModel: LocationDetailViewModel = hiltViewModel(),
    navigateToCharacter: (Int) -> Unit,
    navigateToHome: () -> Unit,
    navigateBack: () -> Unit
) {

    viewModel.getLocation(id)

    val location by viewModel.uiState.collectAsStateWithLifecycle()

    DetailLayout(
        navigateBack = navigateBack,
        navigateToHome = navigateToHome
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(20.dp))
                TextApp(
                    modifier = Modifier.fillMaxWidth(),
                    text = location?.name.orEmpty(),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(20.dp))
                TextAnnotatedApp(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Dimension: ")
                        }
                        append(location?.dimension)
                    },
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(20.dp))
                TextAnnotatedApp(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Type: ")
                        }
                        append(location?.type)
                    },
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(16.dp))
                TextAnnotatedApp(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Location number: ")
                        }
                        append(location?.id.toString())
                    },
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(30.dp))
                TextApp(
                    text = "Residents: ",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(25.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3)
                ) {
                    items(location?.residents ?: emptyList(), key = { it }) { resident ->
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
                                    navigateToCharacter(resident)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            TextApp(
                                text = resident.toString(),
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