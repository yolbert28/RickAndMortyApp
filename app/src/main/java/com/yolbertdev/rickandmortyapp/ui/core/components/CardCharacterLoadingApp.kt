package com.yolbertdev.rickandmortyapp.ui.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.yolbertdev.rickandmortyapp.ui.core.effects.shimmerEffect

@Composable
fun CardCharacterLoadingApp(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.onSurfaceVariant),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .shimmerEffect()
            )
            Column {
                Box(
                    Modifier
                        .padding(start = 20.dp, end = 30.dp)
                        .height(20.dp)
                        .fillMaxWidth()
                        .clip(CircleShape)
                        .shimmerEffect()
                )
                Spacer(Modifier.height(20.dp))
                Box(
                    Modifier
                        .padding(horizontal = 20.dp)
                        .height(16.dp)
                        .fillMaxWidth()
                        .clip(CircleShape)
                        .shimmerEffect()
                )
                Spacer(Modifier.height(20.dp))
                Box(
                    Modifier
                        .padding(start = 20.dp, end = 50.dp)
                        .height(12.dp)
                        .fillMaxWidth()
                        .clip(CircleShape)
                        .shimmerEffect()
                )
            }
        }
    }
}