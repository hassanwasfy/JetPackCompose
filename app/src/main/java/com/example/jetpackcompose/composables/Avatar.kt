package com.example.jetpackcompose.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.Orange50

@Composable
fun ChangeAvatar(){
    Text(
        text = "change avatar", style = TextStyle(
            color = Orange50,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold
        ),
        modifier = Modifier.clickable { Log.i("H015H","Open avatars") }
    )
}