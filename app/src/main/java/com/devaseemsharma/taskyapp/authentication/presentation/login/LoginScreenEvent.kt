package com.devaseemsharma.taskyapp.authentication.presentation.login

import androidx.compose.ui.focus.FocusState

sealed class LoginScreenEvent{
    data class EmailAddressEntered(val txtEmail: String): LoginScreenEvent()
    data class EmailAddressFocusChanged(val focusState: FocusState): LoginScreenEvent()
    data class PasswordEntered(val passwordText: String): LoginScreenEvent()
    data class PasswordFocusChanged(val focusState: FocusState): LoginScreenEvent()
    data class LoginUser(val txtEmail: String, val password: String): LoginScreenEvent()
}
