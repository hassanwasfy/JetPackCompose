package com.example.jetpackcompose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R

@Composable
fun ProfileAvatar() {
    Image(
        modifier = Modifier
            .size(128.dp)
            .clip(shape = RoundedCornerShape((24.dp))),
        painter = painterResource(id = R.drawable.knight),
        contentDescription = "profile avatar"
    )
}