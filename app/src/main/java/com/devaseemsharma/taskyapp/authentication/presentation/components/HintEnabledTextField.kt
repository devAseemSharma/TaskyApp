package com.devaseemsharma.taskyapp.authentication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.devaseemsharma.taskyapp.R
import com.devaseemsharma.taskyapp.ui.theme.LocalSpacing
import com.devaseemsharma.taskyapp.ui.theme.textFieldBgColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HintEnabledTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
    ) {
        TextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black,
                disabledLabelColor = textFieldBgColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .onFocusChanged { onFocusChange(it) }
        )
        if (isHintVisible) {
            Text(
                text = hint, style = textStyle, color = Color.DarkGray, modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Transparent)
                    .padding(spacing.spaceMedium)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HintEnabledPasswordTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {
    val spacing = LocalSpacing.current
    var passwordVisibility = remember { mutableStateOf(false) }
    Box(
        modifier = modifier
    ) {
        TextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black,
                disabledLabelColor = textFieldBgColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val (icon, iconColor) = if (passwordVisibility.value) {
                    Pair(
                        Icons.Filled.Visibility,
                        Color.Black
                    )
                } else {
                    Pair(Icons.Filled.VisibilityOff, Color.LightGray)
                }

                IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                    Icon(
                        icon,
                        contentDescription = "Visibility",
                        tint = iconColor
                    )
                }
            },
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .onFocusChanged { onFocusChange(it) }
        )
        if (isHintVisible) {
            Text(
                text = hint, style = textStyle, color = Color.DarkGray, modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Transparent)
                    .padding(spacing.spaceMedium)
            )
        }
    }
}