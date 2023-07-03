package com.example.jetpackcompose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.Login_Text
import com.example.jetpackcompose.ui.theme.Login_primary
import com.example.jetpackcompose.ui.theme.Login_secondary

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TestInfo() {
    Column {
        InfoEntry("UserName", "HassanWasfy", {})
        PassEntry("UserName", "HassanWasfy", {})
    }
}

@Composable
fun InfoEntry(
    label: String,
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(vertical = 4.dp)
                .height(56.dp),
            label = { Text(label) },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Login_Text,
                unfocusedTextColor = Login_Text,
                focusedContainerColor = Login_primary,
                unfocusedContainerColor = Login_primary,
                focusedIndicatorColor = Login_secondary,
                unfocusedIndicatorColor = Login_Text,
                focusedLabelColor = Color.LightGray,
                unfocusedLabelColor = Login_Text
            )
        )
    }
}

@Composable
fun PassEntry(
    label: String,
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        TextField(value = text,
            onValueChange = onTextChange,
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(vertical = 4.dp)
                .height(56.dp),
            label = { Text(label) },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description,
                        tint = Login_Text)
                }
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Login_Text,
                unfocusedTextColor = Login_Text,
                focusedContainerColor = Login_primary,
                unfocusedContainerColor = Login_primary,
                focusedIndicatorColor = Login_secondary,
                unfocusedIndicatorColor = Login_Text,
                focusedLabelColor = Color.LightGray,
                unfocusedLabelColor = Login_Text
            )
        )
    }
}