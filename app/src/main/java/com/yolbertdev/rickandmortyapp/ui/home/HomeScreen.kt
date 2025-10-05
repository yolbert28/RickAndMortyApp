package com.yolbertdev.rickandmortyapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yolbertdev.rickandmortyapp.R
import com.yolbertdev.rickandmortyapp.ui.core.components.CardHomeApp
import com.yolbertdev.rickandmortyapp.ui.core.components.Footer
import com.yolbertdev.rickandmortyapp.ui.core.components.ImageWithGlassOverlay
import com.yolbertdev.rickandmortyapp.ui.core.components.Layout
import com.yolbertdev.rickandmortyapp.ui.core.components.TextApp

@Composable
fun HomeScreen(
    onChangeTheme: () -> Unit,
    isDarkTheme: Boolean,
    navigateToCharacter: () -> Unit,
    navigateToEpisode: () -> Unit,
    navigateToLocation: () -> Unit,
) {
    Layout(onChangeTheme = onChangeTheme, isDarkTheme = isDarkTheme, navigateToHome = {}) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ImageWithGlassOverlay(
                    text = stringResource(R.string.home_screen_title),
                    image = painterResource(R.drawable.background),
                    modifier = Modifier.height(400.dp)
                )
                Spacer(Modifier.height(40.dp))
                TextApp(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    text = stringResource(R.string.home_screen_subtitle),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.height(20.dp))
                CardHomeApp(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable {
                            navigateToCharacter()
                        },
                    text = stringResource(R.string.home_screen_character_button)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(R.drawable.characters),
                        contentDescription = stringResource(R.string.home_screen_character_button),
                        contentScale = ContentScale.Crop
                    )
                }
                CardHomeApp(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable {
                            navigateToEpisode()
                        },
                    text = stringResource(R.string.home_screen_episodes_button)
                ) {
                    Image(
                        modifier = Modifier
                            .graphicsLayer {
                                translationX = -100f
                                translationY = 20f
                            }
                            .rotate(-15f)
                            .fillMaxHeight(),
                        painter = painterResource(R.drawable.season5),
                        contentDescription = stringResource(R.string.home_screen_episodes_button)
                    )
                    Image(
                        modifier = Modifier
                            .rotate(15f)
                            .graphicsLayer {
                                translationX = 100f
                                translationY = -20f
                            }
                            .fillMaxHeight(),
                        painter = painterResource(R.drawable.season4),
                        contentDescription = stringResource(R.string.home_screen_episodes_button)
                    )
                    Image(
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .fillMaxHeight(),
                        painter = painterResource(R.drawable.season1),
                        contentDescription = stringResource(R.string.home_screen_episodes_button)
                    )
                }
                CardHomeApp(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable {
                            navigateToLocation()
                        },
                    text = stringResource(R.string.home_screen_locations_button)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(R.drawable.planet),
                        contentDescription = stringResource(R.string.home_screen_locations_button),
                        contentScale = ContentScale.Crop
                    )
                }
                Footer()
            }
        }
    }
}