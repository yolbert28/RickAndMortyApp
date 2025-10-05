package com.yolbertdev.rickandmortyapp.ui.character

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yolbertdev.rickandmortyapp.R
import com.yolbertdev.rickandmortyapp.domain.model.CharacterResult
import com.yolbertdev.rickandmortyapp.domain.model.DataError
import com.yolbertdev.rickandmortyapp.domain.model.Result
import com.yolbertdev.rickandmortyapp.domain.model.RootError
import com.yolbertdev.rickandmortyapp.ui.core.components.CardCharacterItemApp
import com.yolbertdev.rickandmortyapp.ui.core.components.CardCharacterLoadingApp
import com.yolbertdev.rickandmortyapp.ui.core.components.Footer
import com.yolbertdev.rickandmortyapp.ui.core.components.ImageWithGlassOverlay
import com.yolbertdev.rickandmortyapp.ui.core.components.Layout
import com.yolbertdev.rickandmortyapp.ui.core.components.PaginationApp
import javax.inject.Inject

@Composable
fun CharacterScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
    onChangeTheme: () -> Unit,
    isDarkTheme: Boolean,
    navigateToDetails: (Int) -> Unit,
    navigateToHome: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Layout(onChangeTheme = onChangeTheme, isDarkTheme = isDarkTheme, navigateToHome = navigateToHome) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            item {
                ImageWithGlassOverlay(
                    text = stringResource(R.string.character_screen_title),
                    image = painterResource(R.drawable.characters),
                    modifier = Modifier.height(380.dp),
                    blurPaddingTop = 250.dp,
                    blurPaddingBottom = 350.dp
                )
                Spacer(Modifier.height(20.dp))
            }

            when (uiState.data) {
                is Result.Success<CharacterResult, DataError.Network> -> {

                    val data =
                        (uiState.data as Result.Success<CharacterResult, DataError.Network>).data


                    items(data.characters, key = { it.id }) { character ->
                        CardCharacterItemApp(
                            character = character,
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                                .clickable {
                                    navigateToDetails(character.id)
                                }
                        )
                    }

                    item {
                        PaginationApp(
                            maxPages = data.pages,
                            currentPage = uiState.currentPage,
                            onChangePage = { page: Int -> viewModel.onChangePage(page) })
                    }
                }

                is Result.Error<CharacterResult, DataError.Network> -> {
                    item {
                        Box(
                            Modifier.height(300.dp).fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = (uiState.data as Result.Error<CharacterResult, DataError.Network>).error.toString()
                            )
                        }
                    }
                }

                Result.Loading -> {
                    items(20) {
                        CardCharacterLoadingApp(
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                        )
                    }

                    item {
                        PaginationApp(
                            maxPages = 1,
                            currentPage = uiState.currentPage,
                            onChangePage = { page: Int -> viewModel.onChangePage(page) })
                    }
                }
            }
            item {
                Footer()
            }
        }
    }
}