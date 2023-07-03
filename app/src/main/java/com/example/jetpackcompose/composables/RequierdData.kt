package com.example.jetpackcompose.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.screens.login.LoginUiState

@Composable
fun RequireData(
    state: LoginUiState,
    onChangeUserName: (String) -> Unit,
    onChangePassword: (String) -> Unit
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        InfoEntry("UserName",state.userName,onChangeUserName)
        SpaceHeightBy(size = 8.dp)
        PassEntry("Password",state.password,onChangePassword)
    }
}