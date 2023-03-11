package com.devaseemsharma.taskyapp.authentication.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.devaseemsharma.taskyapp.authentication.presentation.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.w3c.dom.Text
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {
    private val _emailAddress = mutableStateOf(TextFieldState(
        hint = "Email address"
    ))
    val emailAddress: State<TextFieldState> = _emailAddress

    private val _passwordText = mutableStateOf(TextFieldState(
        hint = "Password"
    ))
    val passwordText: State<TextFieldState> = _passwordText


    fun onEvent(event: LoginScreenEvent){
        when(event){
            is LoginScreenEvent.EmailAddressEntered -> {
                _emailAddress.value = emailAddress.value.copy(
                    text = event.txtEmail
                )
            }

            is LoginScreenEvent.EmailAddressFocusChanged -> {
                _emailAddress.value = emailAddress.value.copy(
                    isHintVisible = !event.focusState.isFocused
                            && emailAddress.value.text.isBlank()
                )
            }

            is LoginScreenEvent.PasswordEntered -> {
                _passwordText.value = passwordText.value.copy(
                    text = event.passwordText
                )
            }

            is LoginScreenEvent.PasswordFocusChanged -> {
                _passwordText.value = passwordText.value.copy(
                    isHintVisible = !event.focusState.isFocused
                            && passwordText.value.text.isBlank()
                )
            }

            is LoginScreenEvent.LoginUser -> {

            }

            else -> {

            }
        }
    }


}