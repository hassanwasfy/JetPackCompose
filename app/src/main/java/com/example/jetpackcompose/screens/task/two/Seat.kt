package com.example.jetpackcompose.screens.task.two

import androidx.annotation.DrawableRes
import kotlin.random.Random


data class Seat(
    val one: Chair,
    val two: Chair
)

data class Chair(
    val status:ChairStatus
)

enum class ChairStatus{
    AVAILABLE,
    TAKEN,
    SELECTED
}

