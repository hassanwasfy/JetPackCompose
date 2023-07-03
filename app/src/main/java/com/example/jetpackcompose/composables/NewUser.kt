package com.example.jetpackcompose.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.Login_Text
import com.example.jetpackcompose.ui.theme.Login_secondary

@Composable
fun NewUser(onSignupClicked: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            textAlign = TextAlign.End,
            modifier = Modifier
                .weight(1f),
            text = "New User?",
            style = TextStyle(color = Login_Text),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        SpaceWidthBy(size = 4.dp)
        Text(
            textAlign = TextAlign.Start,
            modifier = Modifier
                .weight(1f)
                .clickable { onSignupClicked() },
            text = "Sign Up",
            style = TextStyle(color = Login_secondary),
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}