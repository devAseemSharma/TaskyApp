package com.devaseemsharma.taskyapp.utils


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.devaseemsharma.taskyapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskyLargeTopAppBar(
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.background(Color.Black)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                title,
                color = Color.White,
                style = Typography.titleLarge,
            )
        }
    }
}

@Preview
@Composable
fun TaskyLargeTopAppBarPreview() {
    TaskyLargeTopAppBar(title = "Welcome Back!")
}