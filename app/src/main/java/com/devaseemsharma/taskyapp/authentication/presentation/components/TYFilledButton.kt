package com.devaseemsharma.taskyapp.authentication.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devaseemsharma.taskyapp.ui.theme.Typography
import com.devaseemsharma.taskyapp.ui.theme.blackColor

@Composable
fun TYFilledButton(
    buttonText: String,
    enabled: Boolean = true,
    buttonColor: ButtonColors = ButtonDefaults.buttonColors(containerColor = blackColor),
    modifier: Modifier = Modifier,
    actionCallback: () -> Unit,
) {
    Button(
        onClick = actionCallback,
        enabled = enabled,
        colors = buttonColor,
        modifier = modifier
    ) {
        Text(
            text = buttonText.uppercase(),
            style = Typography.bodyMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskyButtonPreview() {
    TYFilledButton(buttonText = "Dummy Text") {

    }
}