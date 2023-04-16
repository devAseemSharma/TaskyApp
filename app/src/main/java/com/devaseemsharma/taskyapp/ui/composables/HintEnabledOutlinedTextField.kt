package com.devaseemsharma.taskyapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import com.devaseemsharma.taskyapp.authentication.presentation.TextFieldState
import com.devaseemsharma.taskyapp.ui.theme.Light2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HintEnabledOutlinedTextField(
    textColor: Color,
    textState: TextFieldState,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        TextField(
            value = textState.text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            placeholder = {
                Text(
                    text = textState.hint,
                    color = Color.DarkGray
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = textColor,
                cursorColor = Black,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Light2)
                .onFocusChanged {
                    onFocusChange(it)
                }
        )
    }
}