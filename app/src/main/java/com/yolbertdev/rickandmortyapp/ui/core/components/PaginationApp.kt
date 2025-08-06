package com.yolbertdev.rickandmortyapp.ui.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun PaginationApp(
    modifier: Modifier = Modifier,
    currentPage: Int,
    maxPages: Int,
    onChangePage: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier
                .size(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            shape = RoundedCornerShape(10),
            contentPadding = PaddingValues(0.dp),
            onClick = {
                onChangePage(currentPage - 1)
            },
            enabled = (currentPage - 1 > 0),
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
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
                text = currentPage.toString(),
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
                .background(MaterialTheme.colorScheme.onSurfaceVariant, RoundedCornerShape(10))
                .clickable{
                    if(currentPage != maxPages)
                        onChangePage(maxPages)
                },
            contentAlignment = Alignment.Center
        ) {
            TextApp(
                text = maxPages.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Spacer(Modifier.width(20.dp))
        Button(
            modifier = Modifier
                .size(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            shape = RoundedCornerShape(10),
            contentPadding = PaddingValues(0.dp),
            onClick = {
                onChangePage(currentPage + 1)
            },
            enabled = (currentPage + 1 <= maxPages)
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(R.drawable.arrow_right),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}