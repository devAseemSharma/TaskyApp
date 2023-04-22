package com.devaseemsharma.taskyapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalTextApi::class)
@Composable
fun TaskyRoundedSolidButton(
    buttonText: String,
    textColor: Color,
    bgColor: Color,
    isEnabled: Boolean,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            disabledContainerColor = Color.LightGray,
        ),
        enabled = isEnabled,
        modifier = modifier
            .fillMaxWidth()
            .background(color = bgColor, shape = RoundedCornerShape(size = 38.dp))
            .height(55.dp)

    ) {
        Text(
            text = buttonText,
            style = TextStyle(
                brush = SolidColor(Color.White),
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
            ),
        )
    }
}