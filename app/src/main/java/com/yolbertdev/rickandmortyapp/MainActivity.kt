package com.yolbertdev.rickandmortyapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yolbertdev.rickandmortyapp.ui.character.CharacterScreen
import com.yolbertdev.rickandmortyapp.ui.core.navigation.NavigationWrapper
import com.yolbertdev.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

val Context.dataStore by preferencesDataStore(name = "THEME_PREFERENCES_MODE")

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val isDarkTheme by getMode().collectAsStateWithLifecycle(false)

            RickAndMortyAppTheme(
                darkTheme = isDarkTheme
            ) {
                NavigationWrapper(
                    onChangeTheme = {
                        lifecycleScope.launch(Dispatchers.IO) {
                            save(!isDarkTheme)
                        }
                    }
                )
            }
        }
    }

    fun getMode() = dataStore.data.map { preferences ->
        preferences[booleanPreferencesKey("mode")] ?: true
    }

    private suspend fun save(theme: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey("mode")] = theme
        }
    }
}
