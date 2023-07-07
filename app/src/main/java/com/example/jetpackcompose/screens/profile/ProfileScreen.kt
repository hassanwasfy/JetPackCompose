package com.example.jetpackcompose.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.jetpackcompose.composables.ChangeAvatar
import com.example.jetpackcompose.composables.Header
import com.example.jetpackcompose.composables.ProfileAvatar
import com.example.jetpackcompose.composables.SignUpButton
import com.example.jetpackcompose.composables.SpaceHeightBy
import com.example.jetpackcompose.composables.SpaceWidthBy
import com.example.jetpackcompose.composables.TextFieldItem
import com.example.jetpackcompose.ui.theme.CustomBackGround
import javax.inject.Inject

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileScreen() {
    //ProfileScreen()
}

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ProfileContent(
        state = state,
        onChangeFirstName = viewModel::onChangeFirstName,
        onChangeLastName = viewModel::onChangeLastName,
        onChangeEmail = viewModel::onChangeEmail,
        onChangeGender = viewModel::onChangeGender,
        onChangeMobile = viewModel::onChangeMobile,
        onChangeLocation = viewModel::onChangeLocation,
        saveUserInformation = { navController.navigate("contacts") },
    )
}


@Composable
private fun ProfileContent(
    state: ProfileUiState,
    onChangeFirstName: (String) -> Unit,
    onChangeLastName: (String) -> Unit,
    onChangeEmail: (String) -> Unit,
    onChangeGender: (String) -> Unit,
    onChangeMobile: (String) -> Unit,
    onChangeLocation: (String) -> Unit,
    saveUserInformation: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(CustomBackGround)
            .fillMaxHeight()
            .padding(horizontal = 16.dp, vertical = 32.dp)
    ) {
        Header()
        SpaceHeightBy(size = 24.dp)
        ProfileAvatar()
        SpaceHeightBy(size = 16.dp)
        ChangeAvatar()
        SpaceHeightBy(size = 16.dp)
        Row {
            Box(modifier = Modifier.weight(1f)) {
                TextFieldItem("First Name", state.firstName, onTextChanged = onChangeFirstName)
            }
            SpaceWidthBy(size = 16.dp)
            Box(modifier = Modifier.weight(1f)) {
                TextFieldItem("Second Name", state.secondName, onTextChanged = onChangeLastName)
            }
        }
        TextFieldItem("Location", state.location, onTextChanged = onChangeLocation)
        TextFieldItem("E-mail", state.email, onTextChanged = onChangeEmail)
        TextFieldItem("Gender", state.gender, onTextChanged = onChangeGender)
        TextFieldItem("Mobile", state.mobile, onTextChanged = onChangeMobile)
        Spacer(modifier = Modifier.weight(1f))
        SignUpButton(onButtonClick = saveUserInformation)
    }
}











