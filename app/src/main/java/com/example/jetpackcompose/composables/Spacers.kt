package com.example.jetpackcompose.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun SpaceHeightBy(size: Dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceWidthBy(size: Dp) {
    Spacer(modifier = Modifier.width(size))
}