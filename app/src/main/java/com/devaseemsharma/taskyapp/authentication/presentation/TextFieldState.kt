package com.devaseemsharma.taskyapp.authentication.presentation

data class TextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)