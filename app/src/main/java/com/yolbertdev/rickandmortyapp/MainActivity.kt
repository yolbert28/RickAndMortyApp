package com.yolbertdev.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yolbertdev.rickandmortyapp.ui.character.CharacterScreen
import com.yolbertdev.rickandmortyapp.ui.core.navigation.NavigationWrapper
import com.yolbertdev.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var isDarkTheme by remember { mutableStateOf(true) }

            RickAndMortyAppTheme(
                darkTheme = isDarkTheme
            ) {
                    NavigationWrapper(onChangeTheme = { isDarkTheme = !isDarkTheme })
            }
        }
    }
}
