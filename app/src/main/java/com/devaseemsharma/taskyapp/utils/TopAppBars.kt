package com.devaseemsharma.taskyapp.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devaseemsharma.taskyapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskyLargeTopAppBar(title: String, modifier: Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                title,
                color = Color.White,
                style = Typography.titleLarge,
                modifier = Modifier.padding(all = 54.dp)
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Black
        ),
        modifier = modifier
    )
}