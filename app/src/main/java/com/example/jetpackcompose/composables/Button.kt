package com.example.jetpackcompose.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.Green50
import com.example.jetpackcompose.ui.theme.Login_primary
import com.example.jetpackcompose.ui.theme.Login_secondary

@Composable
fun SignUpButton(onButtonClick: () -> Unit){
    Button(
        elevation = ButtonDefaults.buttonElevation(0.dp),
        onClick = onButtonClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Green50)
    ) {
        Text(text = "SignUp")
    }
}

@Composable
fun LoginButton(onLoginClicked: () -> Unit) {
    Button(
        onClick = { onLoginClicked() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Login_secondary)
    ) {
        Text(
            text = "Login", style = TextStyle(
                color = Login_primary,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

