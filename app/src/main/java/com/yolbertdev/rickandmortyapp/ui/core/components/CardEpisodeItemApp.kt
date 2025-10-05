package com.yolbertdev.rickandmortyapp.ui.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yolbertdev.rickandmortyapp.domain.model.Episode

@Composable
fun CardEpisodeItemApp(modifier: Modifier = Modifier, episode: Episode , navigateToDetail: () -> Unit) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .height(100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(10))
            .background(MaterialTheme.colorScheme.onBackground)
            .clickable{
                navigateToDetail()
            },
        contentAlignment = Alignment.Center
    ) {

        TextApp(
            text = episode.episode,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}