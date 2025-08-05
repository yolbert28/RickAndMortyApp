package com.yolbertdev.rickandmortyapp.ui.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yolbertdev.rickandmortyapp.R

@Composable
fun PaginationApp(modifier: Modifier = Modifier, navigateToBackPage: () -> Unit, navigateToNextPage: () -> Unit) {
    Row(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(10))
                .clickable{
                    navigateToBackPage()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
        Spacer(Modifier.width(20.dp))
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(MaterialTheme.colorScheme.onSurfaceVariant, RoundedCornerShape(10)),
            contentAlignment = Alignment.Center
        ) {
            TextApp(
                text = "1",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Spacer(Modifier.width(20.dp))
        TextApp(
            text = "of",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(Modifier.width(20.dp))
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(MaterialTheme.colorScheme.onSurfaceVariant, RoundedCornerShape(10)),
            contentAlignment = Alignment.Center
        ) {
            TextApp(
                text = "20",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Spacer(Modifier.width(20.dp))
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(10))
                .clickable{
                    navigateToNextPage()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_right),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}