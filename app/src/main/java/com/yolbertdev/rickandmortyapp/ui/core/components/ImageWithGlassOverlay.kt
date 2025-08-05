package com.yolbertdev.rickandmortyapp.ui.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yolbertdev.rickandmortyapp.ui.theme.blue5
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import dev.chrisbanes.haze.rememberHazeState

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun ImageWithGlassOverlay(
    text: String,
    image: Painter,
    modifier: Modifier = Modifier,
    blurPaddingTop: Dp = 0.dp,
    blurPaddingBottom: Dp = 150.dp,
    fontSize: TextUnit = 32.sp,
    lineHeight: TextUnit = 32.sp
) {

    val hazeState = rememberHazeState()

    Box(
        modifier = modifier.clipToBounds()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .shadow(5.dp, clip = false)
                .shadow(5.dp, clip = false)
                .hazeSource(state = hazeState),
            painter = image,
            contentDescription = "Imagen portada",
            contentScale = ContentScale.Crop,

            )
        Box(
            modifier = Modifier
                .height(blurPaddingBottom)
                .padding(top = blurPaddingTop)
                .shadow(10.dp, clip = false)
                .shadow(10.dp, clip = false)
                .shadow(10.dp, clip = false)
                .fillMaxWidth()
                .background(Color.Transparent)
                .hazeEffect(
                    state = hazeState, style = HazeMaterials.ultraThin(blue5)
                ) {
                    blurRadius = 3.dp
                    noiseFactor = 0.1f
                }, contentAlignment = Alignment.Center
        ) {
            TextApp(
                text = text,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = fontSize,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                lineHeight = lineHeight
            )
        }
    }
}