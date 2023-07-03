package com.example.jetpackcompose.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Account", style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Manage your account", style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Light
            )
        )
    }
}