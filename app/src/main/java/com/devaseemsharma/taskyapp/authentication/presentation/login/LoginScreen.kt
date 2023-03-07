package com.devaseemsharma.taskyapp.authentication.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import com.devaseemsharma.taskyapp.authentication.presentation.components.HintEnabledTextField
import com.devaseemsharma.taskyapp.ui.theme.TaskyAppTheme
import com.devaseemsharma.taskyapp.ui.theme.Typography
import com.devaseemsharma.taskyapp.utils.TaskyLargeTopAppBar
import kotlin.math.log


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {

    val emailAddressState = viewModel.emailAddress.value
    val passwordState = viewModel.passwordText.value

    Box(modifier = Modifier.fillMaxSize()) {
        TaskyLargeTopAppBar(
            "Welcome Back!",
            modifier = Modifier
                .height(160.dp)
                .align(alignment = Alignment.TopCenter)
        )
        Column(
            modifier = Modifier.align(alignment = Alignment.TopCenter)
        ) {
            Spacer(modifier = Modifier.height(130.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    )

            ) {
                Spacer(modifier = Modifier.height(40.dp))
                HintEnabledTextField(
                    text = emailAddressState.text,
                    hint = emailAddressState.hint,
                    onValueChange = {
                        viewModel.onEvent(LoginScreenEvent.EmailAddressEntered(it))
                    },
                    onFocusChange = {
                        viewModel.onEvent(LoginScreenEvent.EmailAddressFocusChanged(it))
                    },
                    isHintVisible = emailAddressState.isHintVisible,
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(40.dp))
                HintEnabledTextField(
                    text = passwordState.text,
                    hint = passwordState.hint,
                    onValueChange = {
                        viewModel.onEvent(LoginScreenEvent.PasswordEntered(it))
                    },
                    onFocusChange = {
                        viewModel.onEvent(LoginScreenEvent.PasswordFocusChanged(it))
                    },
                    isHintVisible = passwordState.isHintVisible,
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyMedium,
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TaskyAppTheme {
        val loginViewModel = LoginViewModel(SavedStateHandle())
        LoginScreen(viewModel = loginViewModel)
    }
}
