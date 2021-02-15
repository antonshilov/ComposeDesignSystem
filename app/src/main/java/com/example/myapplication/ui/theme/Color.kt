package com.example.myapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticAmbientOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
data class ColorTokens(
    val primary: Color,
    val matchPhotosBorder: Color,
    //...
)

val AmbientColors = staticCompositionLocalOf<ColorTokens>()

@Composable
val Colors: ColorTokens
    get() = AmbientColors.current
