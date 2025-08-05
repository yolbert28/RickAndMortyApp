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
import com.yolbertdev.rickandmortyapp.ui.model.LocationUiModel

@Composable
fun LocationDetailScreen(
    id: Int,
    navigateToCharacter: (Int) -> Unit,
    navigateToHome: () -> Unit,
    navigateBack: () -> Unit
) {

    val location = LocationUiModel(
        id = 3,
        name = "Citadel of Ricks",
        type = "Space station",
        dimension = "unknown",
        residents = listOf(
            8,
            14,
            15,
            18,
            21,
            22,
            27,
            42,
            43,
            44,
            48,
            53,
            56,
            61,
            69,
            72,
            73,
            74,
            77,
            78,
            85,
            86,
            95,
            118,
            119,
            123,
            135,
            143,
            152,
            164,
            165,
            187,
            200,
            206,
            209,
            220,
            229,
            231,
            235,
            267,
            278,
            281,
            283,
            284,
            285,
            286,
            287,
            288,
            289,
            291,
            295,
            298,
            299,
            322,
            325,
            328,
            330,
            345,
            359,
            366,
            378,
            385,
            392,
            461,
            462,
            463,
            464,
            465,
            466,
            472,
            473,
            474,
            475,
            476,
            477,
            478,
            479,
            480,
            481,
            482,
            483,
            484,
            485,
            486,
            487,
            488,
            489,
            2,
            1,
            801,
            802,
            803,
            804,
            805,
            806,
            810,
            811,
            812,
            819,
            820,
            818
        )
    )
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
                    text = location.name,
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
                        append(location.dimension)
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
                        append(location.type)
                    },
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(Modifier.height(16.dp))
                TextAnnotatedApp(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Location number: ")
                        }
                        append("${location.id}")
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
                    items(location.residents, key = { it }) { resident ->
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
                                text = "$resident",
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