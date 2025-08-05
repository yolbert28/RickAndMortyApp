package com.yolbertdev.rickandmortyapp.ui.character

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yolbertdev.rickandmortyapp.R
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
    navigateToDetails: (Int) -> Unit,
    navigateToHome: () -> Unit
) {

    viewModel.getCharacters()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Layout(onChangeTheme = onChangeTheme, navigateToHome = navigateToHome) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn {
                item {
                    ImageWithGlassOverlay(
                        text = "Personajes",
                        image = painterResource(R.drawable.characters),
                        modifier = Modifier.height(380.dp),
                        blurPaddingTop = 250.dp,
                        blurPaddingBottom = 350.dp
                    )
                    Spacer(Modifier.height(20.dp))
                }

                if (uiState.characters.isNotEmpty()) {
                    items(uiState.characters) { character ->
                        CardCharacterItemApp(
                            character = character,
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                                .clickable {
                                    navigateToDetails(character.id)
                                }
                        )
                    }
                } else {
                    items(20){
                        CardCharacterLoadingApp(
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                        )
                    }
                }
                item {
                    PaginationApp(navigateToBackPage = {}, navigateToNextPage = {})
                    Footer()
                }
            }
        }
    }
}