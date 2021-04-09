package com.example.myapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ColorTokens(
    val primary: Color = Color.White,
    val matchPhotosBorder: Color = Color.White,
    //...
)

val LocalColors = staticCompositionLocalOf { ColorTokens() }

val Colors: ColorTokens
    @Composable
    get() = LocalColors.current
