package com.yolbertdev.rickandmortyapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = blue70,
    secondary = green70,
    tertiary = blue70,
    onPrimary = blue5,
    onSecondary = blue5,
    background = blue10,
    onBackground = blue70,
    onSurfaceVariant = blue50,
    onSurface = blue70,
    onPrimaryContainer = blue5
)

private val LightColorScheme = lightColorScheme(
    primary = green80,
    secondary = green5,
    tertiary = green5,
    onPrimary = green80,
    onSecondary = green5,
    background = green95,
    onBackground = green85,
    onSurfaceVariant = green50,
    onSurface = green95,
    onPrimaryContainer = green5
)

@Composable
fun RickAndMortyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}