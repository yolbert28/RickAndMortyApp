package com.yolbertdev.rickandmortyapp.ui.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yolbertdev.rickandmortyapp.R

@Composable
fun DetailLayout(navigateBack: () -> Unit, navigateToHome: () -> Unit, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onSurfaceVariant)
            ){
                Box(
                    modifier = Modifier.padding(top = 40.dp).fillMaxWidth().background(MaterialTheme.colorScheme.primary)
                ){
                    Icon(
                        modifier = Modifier
                            .padding(start = 10.dp, top = 10.dp)
                            .size(50.dp)
                            .align(Alignment.CenterStart)
                            .clickable{
                                navigateBack()
                            },
                        painter = painterResource(R.drawable.arrow_back),
                        contentDescription = stringResource(R.string.detail_layout_button_back_content_description),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                    Icon(
                        modifier = Modifier
                            .padding(end = 15.dp, top = 10.dp)
                            .size(50.dp)
                            .align(Alignment.CenterEnd)
                            .clickable{
                                navigateToHome()
                            },
                        painter = painterResource(R.drawable.home),
                        contentDescription = stringResource(R.string.detail_layout_button_home_content_description),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
            }
        },
        bottomBar = {
            Box(
                Modifier.background(MaterialTheme.colorScheme.primary)
            ){
                Footer()
            }
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}