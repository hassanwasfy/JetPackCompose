package com.example.jetpackcompose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.Login_primary
import com.example.jetpackcompose.ui.theme.Login_secondary


@Composable
fun LoginAvatar(){
    Image(
        painter = painterResource(id = R.drawable.image_vector),
        contentDescription = "Image vector",
        modifier = Modifier
            .background(
                color = Login_secondary, shape = RoundedCornerShape(120.dp)
            )
            .padding(16.dp)
            .size(64.dp),
        colorFilter = ColorFilter.tint(Login_primary)
    )
}