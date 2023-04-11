package com.devaseemsharma.taskyapp.authentication.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.devaseemsharma.taskyapp.authentication.presentation.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.w3c.dom.Text
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {
    var state = MutableStateFlow(LoginState())
        private set


    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.EmailAddressEntered -> {
                state.update {
                    it.copy(
                        emailAddress = TextFieldState(
                            text = event.txtEmail,
                            isHintVisible = it.emailAddress.isHintVisible,
                            hint = it.emailAddress.hint
                        )
                    )
                }
            }

            is LoginScreenEvent.EmailAddressFocusChanged -> {
                state.update {
                    it.copy(
                        emailAddress = TextFieldState(
                            text = it.emailAddress.text,
                            isHintVisible =  !event.focusState.isFocused
                                    && it.emailAddress.text.isBlank(),
                            hint = it.emailAddress.hint
                        )
                    )
                }
            }

            is LoginScreenEvent.PasswordEntered -> {
                state.update {
                    it.copy(
                        passwordText = TextFieldState(
                            text = event.passwordText,
                            isHintVisible = it.passwordText.isHintVisible,
                            hint = it.passwordText.hint
                        )
                    )
                }
            }

            is LoginScreenEvent.PasswordFocusChanged -> {
                state.update {
                    it.copy(
                        emailAddress = TextFieldState(
                            text = it.passwordText.text,
                            isHintVisible = !event.focusState.isFocused
                                    && it.passwordText.text.isBlank(),
                            hint = it.emailAddress.hint
                        )
                    )
                }
            }

            is LoginScreenEvent.LoginUser -> {

            }

            else -> {

            }
        }
    }


}

data class LoginState(
    var emailAddress: TextFieldState = TextFieldState(hint = "Email address"),
    var passwordText: TextFieldState = TextFieldState(hint = "Password"),
    var isLoading: Boolean = false
)