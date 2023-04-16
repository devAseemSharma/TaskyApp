package com.devaseemsharma.taskyapp.authentication.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devaseemsharma.taskyapp.R
import com.devaseemsharma.taskyapp.authentication.presentation.TextFieldState
import com.devaseemsharma.taskyapp.ui.composables.HintEnabledOutlinedTextField
import com.devaseemsharma.taskyapp.ui.composables.TaskyContent
import com.devaseemsharma.taskyapp.ui.theme.TaskyAppTheme
import com.devaseemsharma.taskyapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginScreenEvent) -> Unit
) {
    val emailAddressState = state.emailAddress
    val passwordState = state.passwordText

    Scaffold(
        content = { contentPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .padding(40.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.welcome_back),
                        color = Color.White,
                        style = Typography.titleLarge
                    )
                }



                TaskyContent(modifier = Modifier.background(Color.Black)) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(contentPadding)
                            .background(
                                color = Color.White,
                            )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(all = 16.dp)

                        ) {
                            Spacer(modifier = Modifier.height(20.dp))
                            HintEnabledOutlinedTextField(
                                textColor = Color.Black,
                                textState = TextFieldState(
                                    emailAddressState.text,
                                    emailAddressState.hint
                                ),
                                onValueChange = {
                                    onEvent(LoginScreenEvent.EmailAddressEntered(it))
                                },
                                onFocusChange = {
                                    onEvent(LoginScreenEvent.EmailAddressFocusChanged(it))
                                },

                                singleLine = true,
                                textStyle = MaterialTheme.typography.bodyMedium,
                            )
                            Spacer(modifier = Modifier.height(40.dp))
                            HintEnabledOutlinedTextField(
                                textColor = Color.Black,
                                textState = TextFieldState(
                                    passwordState.text,
                                    passwordState.hint),
                                onValueChange = {
                                    onEvent(LoginScreenEvent.PasswordEntered(it))
                                },
                                onFocusChange = {
                                    onEvent(LoginScreenEvent.PasswordFocusChanged(it))
                                },
                                singleLine = true,
                                textStyle = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TaskyAppTheme {
        val state = LoginState()
        LoginScreen(state) {}
    }
}
