package com.example.jetpackcompose.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.Login_Text

@Composable
fun ForgotPassword(onForgetPassword: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clickable { onForgetPassword() },
            text = "Forgot Password?",
            style = TextStyle(color = Login_Text),
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}