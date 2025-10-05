package com.yolbertdev.rickandmortyapp.ui.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yolbertdev.rickandmortyapp.R

@Composable
fun Layout(onChangeTheme: () -> Unit, isDarkTheme: Boolean, navigateToHome: () -> Unit, content: @Composable (innerPadding: PaddingValues) -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBarApp(onChangeTheme = onChangeTheme, isDarkTheme = isDarkTheme, navigateToHome = navigateToHome) }) { innerPadding ->
        content(innerPadding)
    }

}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .height(80.dp)
            .background(MaterialTheme.colorScheme.onSurfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        TextApp(
            text = stringResource(R.string.footer)
        )
    }
}