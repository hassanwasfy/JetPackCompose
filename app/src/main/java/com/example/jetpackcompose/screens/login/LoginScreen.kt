package com.example.jetpackcompose.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetpackcompose.composables.ForgotPassword
import com.example.jetpackcompose.composables.LoginAvatar
import com.example.jetpackcompose.composables.LoginButton
import com.example.jetpackcompose.composables.NewUser
import com.example.jetpackcompose.composables.RequireData
import com.example.jetpackcompose.composables.SpaceHeightBy
import com.example.jetpackcompose.ui.theme.Login_primary

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TestLoginScreen() {
    //LoginScreen()
}

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LoginScreenContent(state = state,
        onChangeUserName = viewModel::onChangeUsername,
        onChangePassword = viewModel::onChangePassword,
        onForgetPassword = viewModel::onForgetPassword,
        onLoginClicked = viewModel::onLogin,
        onSignupClicked = {navController.navigate("sign")}
    )
}

@Composable
private fun LoginScreenContent(
    state: LoginUiState,
    onChangeUserName: (String) -> Unit,
    onChangePassword: (String) -> Unit,
    onForgetPassword: () -> Unit,
    onLoginClicked: () -> Unit,
    onSignupClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Login_primary)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpaceHeightBy(size = 128.dp)
        LoginAvatar()
        SpaceHeightBy(size = 32.dp)
        RequireData(state,onChangeUserName,onChangePassword)
        SpaceHeightBy(size = 16.dp)
        ForgotPassword(onForgetPassword)
        SpaceHeightBy(size = 16.dp)
        LoginButton(onLoginClicked)
        SpaceHeightBy(size = 16.dp)
        NewUser(onSignupClicked)
    }
}