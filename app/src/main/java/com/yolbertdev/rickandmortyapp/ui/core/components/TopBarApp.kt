package com.yolbertdev.rickandmortyapp.ui.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yolbertdev.rickandmortyapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp(onChangeTheme: () -> Unit, navigateToHome: () -> Unit) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier.width(200.dp).align(Alignment.Center).clickable{
                        navigateToHome()
                    },
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Rick and Morty Logo"
                )
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterEnd)
                        .clickable{
                            onChangeTheme()
                        },
                    painter = painterResource(R.drawable.light_mode),
                    contentDescription = "Change mode",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        },
        modifier = Modifier
            .shadow(10.dp, clip = false)
            .shadow(10.dp, clip = false)
            .shadow(10.dp, clip = false)
            .shadow(10.dp, clip = false)
            .shadow(10.dp, clip = false)
            .shadow(10.dp, clip = false),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    )

}